app.controller('personController', [
    '$scope',
    'personService',
    '$window',
    '$location',
    '$timeout', function ($scope, personService) {
        console.log('entering person controller');

        $scope.person = {
            personId: '',
            personName: '',
            personEmail: '',
            personAge: ''
        };

        $scope.personUpdate = {
            personId: '',
            personName: '',
            personEmail: '',
            personAge: ''
        };

        $scope.persons = [];

        function fetchAllPersons() {
            console.log('entering fetchAll persons in controller');
            personService.fetchAllPersons().then(function (data) {
                console.log("controller" + data);
                $scope.persons = data;
            }, function (error) {
                console.log('Error : ' + error)
            });
        }

        fetchAllPersons();


        $scope.createPerson = function () {
            console.log('create Person...');
            personService.createPerson($scope.person).then(function (data) {
                toastr["success"](data.personId + "  Created successfully!");
                $scope.person = {};
                fetchAllPersons();
            }, function (error) {
                console.error('Error While Creating ', error);
                toastr["error"]("Create User failed")
            })
        };

        $scope.getPersonById = function (personId) {
            console.log('getting person by Id');
            personService.getPersonById(personId).then(function (data) {
                    $scope.person = data;
                },
                function (errResponse) {
                    console.error('Error while updating : ' + errResponse);
                    toastr["error"]("Updating User failed")
                });
        };


        $scope.updatePerson = function (personId, person) {
            console.log('entering updatePerson in controller' + personId);
            personService.updatePerson(personId, person).then(function (data) {
                    toastr["success"](data.personId + "  Updated successfully!");
                    fetchAllPersons();

                },
                function (errResponse) {
                    console.error('Error while updating : ' + errResponse);
                    toastr["error"]("Updating User failed")
                });
        };

        $scope.updatePersonDetails = function () {
            console.log('updating', $scope.personUpdate.personId);
            $scope.updatePerson($scope.personUpdate.personId, $scope.personUpdate);
        };

        $scope.updateLog = function (person) {
            $scope.personUpdate = person;
        };

        $scope.deletePerson = function (personId) {
            console.log('entering deletePerson in controller personId : ' + personId);
            personService.deletePerson(personId).then(function () {
                console.log('Deleted Successfully');
                toastr["success"]("  Deleted successfully!");
                fetchAllPersons();
            }, function () {
                console.log('Unable to delete')
            })
        };

    }]);
