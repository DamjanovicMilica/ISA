(function () {
    
      'use strict';
    
      angular.module('bioskopPoy').controller('FriendsPageController', FriendsPageController);
    
      FriendsPageController.$inject = ['$scope', '$state', '$route', '$location', 'sessionService', 'guestService', 'notifyService', 'authenticationService', '$window'];
    
      function FriendsPageController($scope, $state, $route, $location, sessionService, guestService, notifyService, authenticationService, $window) {
        $scope.userInfo = sessionService.getUserInfo();
    
        $scope.friendsPage = [];
    
        $scope.currentSort = "nameAndSurname";
    
        $scope.changeSort = function (sortBy) {
          console.log("Change sort called with:" + sortBy);
          $scope.currentSort = sortBy;
        };
    
    
        guestService.getFriendsPageInfo($scope.userInfo.userId).then(function (response) {
    
          $scope.friendsPage = response.data;
    
        }, function (error) {
    
        });
    
    
    
        guestService.addPeople($scope.userInfo.userId).then(function (response) {
          $scope.addPeople = response.data;
        }, function (error) {
    
        });
    
        $scope.dodaj = function (id) {
          guestService.sendFriendshipRequest(id).then(function (response) {
    
            notifyService.showInfo("uspesno kreiran zahtev za prijateljstvo");
            $window.location.reload();
          }, function (error) {
    
          });
    
        };
    
        guestService.acceptPeople($scope.userInfo.userId).then(function (response) {
          $scope.acceptPeople = response.data;
        }, function (error) {
    
        });
    
        $scope.prihvati = function (id) {
          guestService.acceptFriendshipRequest(id).then(function (response) {
    
            notifyService.showInfo("uspesno prihvacen zahtev za prijateljstvo");
           
            $window.location.reload();
          }, function (error) {
    
          });
        }
    
        $scope.odbaci = function (id) {
          guestService.rejectFriendshipRequest(id).then(function (response) {
    
            notifyService.showInfo("uspesno odbijen zahtev za prijateljstvo");
            $window.location.reload();
    
          }, function (error) {
    
          });
        }
    
        $scope.ukloni = function (id) {
          guestService.deleteFriend(id).then(function (response) {
    
            notifyService.showInfo("uspesno izbrisan prijatelj" + id);
            $window.location.reload();
    
          }, function (error) {
    
          });
        };
    
    
    
    
    
        $scope.logoff = function () {
          notifyService.showInfo("logoff called");
          authenticationService.logoff();
          $window.location.href = '/#/login';
    
        };
    
      }
    })();
    