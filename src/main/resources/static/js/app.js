var app = angular.module('myApp', ['ngCookies']);

app.directive('myEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if (event.which === 13 && event.ctrlKey === true) {
                scope.$apply(function () {
                    scope.$eval(attrs.myEnter);
                });
                event.preventDefault();
            }
        });
    };
});

app.controller('MessageListController', function ($scope, $cookieStore) {
    var messageList = this;
    messageList.username = 'test'
   	messageList.author = 'test'	

    if (messageList.username) {
        messageList.author = messageList.username;
        connect();
    }

    function connect() {
        var socket = new SockJS('/ws');
        var stompClient = Stomp.over(socket);

        stompClient.connect({}, function (frame) {
            stompClient.subscribe('/app/trade', function (data) {
                messageList.messages = JSON.parse(data.body);
                $scope.$apply();

                stompClient.subscribe('/topic/trade', function (data) {
                    var message = JSON.parse(data.body);
                    messageList.messages.unshift(message);
                    $scope.$apply();
                });
            });
        });

        messageList.sendMessage = function () {
            if (messageList.author && messageList.ticker) {
                var data = {
                    ticker: messageList.ticker,
                    name: messageList.name,
                    price: messageList.price
                };
                stompClient.send("/app/trade", {}, JSON.stringify(data));
                messageList.ticker = '';
                messageList.name = '';
                messageList.price = '';
            }
        };
    }

  
});



