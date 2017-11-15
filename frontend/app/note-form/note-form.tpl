<div class="col-md-6 col-md-offset-3">
<form name="vm.noteForm" ng-submit="vm.onSubmit(vm.title, vm.text)" class="panel panel-default">
    <div class="panel-body">
        <div class="form-group">
            <label for="title">Name</label>
            <input id="title" name="title" class="form-control" ng-model="vm.title" type="text" placeholder="Please enter your name ..." autocomplete="off" required>
        </div>

        <div class="form-group">
            <label for="text">File Name</label>
            <input id="text" name="text" class="form-control" ng-model="vm.text" placeholder="Please enter the file name ..." required>
        </div>
    </div>

    <div class="panel-footer text-right">
        <button type="submit" class="btn btn-xs btn-success" >Submit</button>
        <button type="reset" class="btn btn-xs btn-default" ng-click="vm.onReset()">Reset</button>
    </div>

</form>
</div>