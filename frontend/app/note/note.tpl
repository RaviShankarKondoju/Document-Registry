<div ng-switch on="vm.isEditingNote">
    <div class="panel panel-default" ng-switch-when="false">
        <div class="panel-heading">
            <h3 class="panel-title pull-left">{{vm.data.title}}</h3>
            <div class="pull-right">
                <a ng-click="vm.editNote()" class="btn btn-xs btn-info">Edit</a>
                <a ng-click="vm.removeNote()" class="btn btn-xs btn-danger">Remove</a>
            </div>

            <div class="clearfix"></div>
        </div>
        <div id="header_name" class="panel-body">{{vm.data.header_name}}</div>
        <button class="btn" data-clipboard-action="copy" data-clipboard-target="#header_name">Copy</button>
    </div>

    <note-form ng-switch-when="true" data="vm.data" on-submit="vm.submitEditedNote" on-reset="vm.resetEditedNote"></note-form>
</div>