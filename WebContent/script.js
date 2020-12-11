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