function NoteFormController(noteService) {
    var vm = this;

    vm.$onInit = $onInit;

    vm.onSubmit = vm.onSubmit || onUserDidSubmit;
    vm.onReset  = vm.onReset || onUserDidReset;

    vm.showError = showError;

    function $onInit() {
        var parentControllerHasSetData = angular.isDefined(vm.data);
        vm.title = parentControllerHasSetData ? vm.data.title : '';
        vm.text  = parentControllerHasSetData ? vm.data.text  : '';
        vm.header_name  = parentControllerHasSetData ? vm.data.header_name  : '';
    }

    function onUserDidSubmit(title, text) {
        return noteService.create(title, text)
            .then(vm.notesController.refreshNotes)
            .then(onUserDidReset)
            .catch(vm.showError);

    }

    function onUserDidReset() {
        vm.title = '';
        vm.text = '';
        vm.noteForm.$setPristine();
        vm.noteForm.$setUntouched();

    }

    function showError(response) {
        alert(response.data.errors.join("\n"));
    }
}