app.factory('personService', function ($http) {
    console.log('starting personService');
    var BASE_URL = "http://localhost:8080/webApi/";

    var personService = this;

    personService.fetchAllPersons = function () {
        console.log('entering getAllPersons');
        return $http.get(BASE_URL + "persons/").then(
            function (response) {
                return response.data
            }, function (errResponse) {
                console.error('Error while getting all Blogs');
                return errResponse.data
            });
    };

    personService.getPersonById = function (personId) {
        return $http.get(BASE_URL + "persons/" + personId).then(
            function (response) {
                return response.data
            }, function (errResponse) {
                console.error('Error while getting all Blogs');
                return errResponse.data
            });
    };

    personService.createPerson = function (person) {
        console.log('entering createPerson');
        return $http.post(BASE_URL + "persons/", person).then(
            function (response) {
                return response.data
            }, function (errResponse) {
                console.error('Error while Creating Persons');
                return errResponse.data
            });
    };

    personService.updatePerson = function (personId, person) {
        console.log('entering update PersonId : ' + personId + person);
        return $http.put(BASE_URL + "persons/" + personId, person).then(function (response) {
            console.log(response);
            return response.data
        }, function (errResponse) {
            console.error('Error while Updating Persons');
            return errResponse.data
        });
    };

    personService.deletePerson = function (personId) {
        console.log('entering service delete');
        return $http.delete(BASE_URL + "persons/" + personId).then(
            function (response) {
                console.log(response.status);
                return response.data;
            }, function (errResponse) {
                console.log(errResponse.status);
                return errResponse.data;
            })
    };

    return personService;

});
