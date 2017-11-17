<div class="container">
    <navigation class="row"></navigation>

    <div class="row">
        <note-form class="col-xs-12" ng-if="location.path() != '/headerlist'" ></note-form>

        <!--<div class="col-xs-12 text-center" ng-if="!vm.hasNotes()">-->
            <!--<div class="alert alert-info" role="alert">-->
                <!--<h4>Oh no!</h4>-->
                <!--<p>There are no notes yet.</p>-->
            <!--</div>-->
        <!--</div>-->
    </div>

    <div class="row" ng-if="location.path() != '/'" >
        <note class="col-xs-6" ng-repeat="note in vm.notes" data="note"></note>
    </div>
</div>