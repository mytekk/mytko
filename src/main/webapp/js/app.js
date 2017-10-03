var app = angular.module('app', []);

app.service('TaskCRUDService', ['$http', function ($http) {

    this.getTask = function getTask(taskId) {
        return $http({
            method: 'GET',
            url: 'tasks/' + taskId
        });
    }

    this.addTask = function addTask(title, description) {
        return $http({
            method: 'POST',
            url: 'tasks',
            data: {
                title: title,
                description: description
            }
        });
    }

    this.updateTask = function updateTask(id, title, description) {
        return $http({
            method: 'PATCH',
            url: 'tasks/' + id,
            data: {
                title: title,
                description: description
            }
        });
    }

    this.deleteTask = function deleteTask(id) {
        return $http({
            method: 'DELETE',
            url: 'tasks/' + id
        })
    }

    this.getAllTasks = function getAllTasks() {
        return $http({
            method: 'GET',
            url: 'tasks'
        });
    }

}]);

app.controller('TaskCRUDCtrl', ['$scope', 'TaskCRUDService', '$window', function ($scope, TaskCRUDService, $window) {

    $scope.getTask = function () {
        var id = $scope.task.id;
        TaskCRUDService.getTask($scope.task.id)
            .then(
                function success(response) {
                    $scope.task = response.data;
                    $scope.task.id = id;
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.message = '';
                    if (response.status === 404) {
                        $scope.errorMessage = 'Task not found!';
                    }
                    else {
                        $scope.errorMessage = "Error getting task!";
                    }
                }
            );
    };

    $scope.addTask = function () {
        if ($scope.task != null && $scope.task.title) {
            TaskCRUDService.addTask($scope.task.title, $scope.task.description)
                .then(
                    function success(response) {
                        $scope.message = 'Task added!';
                        $scope.errorMessage = '';
                    },
                    function error(response) {
                        $scope.message = '';
                        $scope.errorMessage = 'Error adding task!';
                    }
                );
        }
        else {
            $scope.message = '';
            $scope.errorMessage = 'Please enter a title!';
        }
        $window.location.reload();
    }

    $scope.updateTask = function () {
        TaskCRUDService.updateTask($scope.task.id, $scope.task.title, $scope.task.description)
            .then(
                function success(response) {
                    $scope.message = 'Task updated!';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.message = '';
                    $scope.errorMessage = 'Error updating task!';
                }
            );
        $window.location.reload();
    }

    $scope.deleteTask = function () {
        TaskCRUDService.deleteTask($scope.task.id)
            .then(
                function success(response) {
                    $scope.message = 'Task deleted!';
                    $scope.errorMessage = '';
                    $scope.task = null;
                },
                function error(response) {
                    $scope.message = '';
                    $scope.errorMessage = 'Error deleting task!';
                }
            )
        $window.location.reload();
    }

    $scope.getAllTasks = function () {
        TaskCRUDService.getAllTasks()
            .then(
                function success(response) {
                    $scope.tasks = response.data._embedded.tasks;
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.tasks = null;
                    $scope.message = '';
                    $scope.errorMessage = "Error getting tasks!";
                }
            )
    }

}]);
