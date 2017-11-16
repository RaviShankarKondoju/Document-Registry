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
        <div>
            <!--<span class="fw-code-copy">-->
            <!--<span class="fw-code-copy-button">Copy</span>-->
            <!--<div id="modal" class="panel-body header_name"> <code>{{vm.data.header_name}}</code></div>-->
                <!--</span>-->
            <!--</span>-->
            <!--<button class="btn" data-clipboard-action="copy">Copy</button>-->

            <div class="panel-body fw-code-copy">{{vm.data.header_name}}</div>
            <button class="btn fw-code-copy-button">Copy</button>

        </div>
    </div>
    <note-form ng-switch-when="true" data="vm.data" on-submit="vm.submitEditedNote" on-reset="vm.resetEditedNote"></note-form>
</div>