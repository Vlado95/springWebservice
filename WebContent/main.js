function myFunction() {
	$('[data-toggle="tooltip"]').tooltip();
	$('[data-toggle="popover"]').popover();
	$('div#dialog').on('hidden.bs.modal', function(e) {
		$(this).removeData('bs.modal');
		$(this).find('.modal-content').html();
	});
	$('div#dialog').on('shown.bs.modal', function(e) {
		var url = $(e.relatedTarget).data('url');
		$(this).find('.modal-content').load(url);
	});
};

function collMofiyFrom() {
	$('[data-toggle="tooltip"]').tooltip();
	$('[data-toggle="popover"]').popover();
	$('div#dialog').on('hidden.bs.modal', function(e) {
		$(this).removeData('bs.modal');
		$(this).find('.modal-content').html();
	});
	$('div#dialog').on('shown.bs.modal', function(e) {
		
		var value = $('input').val();
		$('h1').html(value);
		var url = $(e.relatedTarget).data('url');
		$(this).find('.modal-content').load(url);
	});
//	$('#btnLaunch').click(function() {
//		$('#myModal').modal('show');
//	});
//
//	$('#btnSave').click(function() {
//		var value = $('input').val();
//		$('h1').html(value);
//		$('#myModal').modal('hide');
//	});
}