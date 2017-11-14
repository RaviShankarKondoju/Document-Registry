function noteService($http, $interpolate) {
    var note = $interpolate('/api/registry/{{id}}');

    return {
        list: list,
        create: create,
        destroy: destroy,
        update: update
    };

    function list() {
        return $http.get(note());
    }

    function create(title, text) {
        var data = {
            title: title,
            text: text
        };

        return $http.post(note(), data);
    }

    function destroy(id) {
        return $http.delete(note({ id: id }));
    }

    function update(id, title, text) {
        var data = {
            title: title,
            text: text
        };

        return $http.put(note({ id: id }), data);
    }
}