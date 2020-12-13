/**
 * Script pour la div selection ON et OFF -----> section filtre page listeEnchere connecte
 */

  // Disable checkbox
$("input[value='0']").change(function() {
    $("input[name='mesVentes']").prop('disabled', true);
    $("input[name='mesVentes']").prop('checked', false);
    $("input[name='achat']").prop('disabled', false);
  });
  
  // Enable checkbox
  $("input[value='1']").change(function() {
    $("input[name='achat']").prop('disabled', true);
    $("input[name='achat']").prop('checked', false);
    $("input[name='mesVentes']").prop('disabled', false);
  });
  
  $(function () {
	$('#search').on('input', function () {
		searchRow();
	});
})

function searchRow() {
	var $rows = $('#table > tbody > tr').not(".header");
	var val1 = $.trim($('#search').val()).replace(/ +/g, ' ').toLowerCase();
	var val2 = $.trim($("#deviceSelector").text()).toLowerCase();
	val2 = (val2 === "devices") ? "" : val2;

	$rows.show().filter(function () {
		var text1 = $(this).find('td:nth-child(1)').text().replace(/\s+/g, ' ').toLowerCase();
		var text2 = $(this).find('td:nth-child(2)').text().replace(/\s+/g, ' ').toLowerCase();
		return !~text1.indexOf(val1) || !~text2.indexOf(val2);
	}).hide();
}

function searchTableDevice(device) {
	var filter, table, tr, td, i;

	$("#deviceSelector").html(device);

	if (device == "all") {
		$("#deviceSelector").html("Devices");
	}

	searchRow();
}