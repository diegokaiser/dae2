$("body").on('scroll', function () {
  if ($("body").scrollTop() > 70) {
    $("header").addClass("scrolled");
  } else {
    $("header").removeClass("scrolled");
  }
});

$(document).ready(function() {

})


$(window).on("load", function(){
  $(".preloader").addClass("loaded");
})