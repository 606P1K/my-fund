//start of validation block
$(document).ready(function() {
  // валідація форми при відправці
  $("#needs-validation").submit(function(event) {
    if ($("#from-who").val() === "") {
      $("#from-who").addClass("is-invalid");
      event.preventDefault();
    }
    if ($("#military-unit-number").val() === "") {
      $("#military-unit-number").addClass("is-invalid");
      event.preventDefault();
    }
    if ($("#brigade-number-or-unit-name").val() === "") {
      $("#brigade-number-or-unit-name").addClass("is-invalid");
      event.preventDefault();
    }
    if ($("#battalion-number").val() === "") {
      $("#battalion-number").addClass("is-invalid");
      event.preventDefault();
    }
    if ($("#company-platoon").val() === "") {
      $("#company-platoon").addClass("is-invalid");
      event.preventDefault();
    }

    if ($("#email").val() === "") {
      $("#email").addClass("is-invalid");
      event.preventDefault();
    } else {
      let email = $("#email").val();
      let emailRegex = /^\S+@\S+\.\S+$/;
      if (!emailRegex.test(email)) {
        $("#email").addClass("is-invalid");
        event.preventDefault();
      }
    }

    if ($("#unit-commander").val() === "") {
      $("#unit-commander").addClass("is-invalid");
      event.preventDefault();
    }
    if ($("#name-and-count").val() === "") {
      $("#name-and-count").addClass("is-invalid");
      event.preventDefault();
    }
    if ($("#current-location").val() === "") {
      $("#current-location").addClass("is-invalid");
      event.preventDefault();
    }
    if ($("#contact-person").val() === "") {
      $("#contact-person").addClass("is-invalid");
      event.preventDefault();
    }

    if ($("#person-number").val() === "") {
      $("#person-number").addClass("is-invalid");
      event.preventDefault();
    } else {
      let personNumber = $("#person-number").val();
      let personNumberRegex = /^\+380\d{9}$/;
      if (!personNumberRegex.test(personNumber)) {
        $("#person-number").addClass("is-invalid");
        event.preventDefault();
      }
    }
  });



  // валідація поля "Від кого запит" при виборі значення
  $("#from-who").change(function() {
    if ($("#from-who").val() !== "") {
      $("#from-who").removeClass("is-invalid");
    }
  });

  // валідація текстових полів при введенні значення
  $("#military-unit-number").keyup(function() {
    if ($("#military-unit-number").val() !== "") {
      $("#military-unit-number").removeClass("is-invalid");
    }
  });

  $("#brigade-number-or-unit-name").keyup(function() {
    if ($("#brigade-number-or-unit-name").val() !== "") {
      $("#brigade-number-or-unit-name").removeClass("is-invalid");
    }
  });

  $("#battalion-number").keyup(function() {
    if ($("#battalion-number").val() !== "") {
      $("#battalion-number").removeClass("is-invalid");
    }
  });

  $("#company-platoon").keyup(function() {
    if ($("#company-platoon").val() !== "") {
      $("#company-platoon").removeClass("is-invalid");
    }
  });

  $("#unit-commander").keyup(function() {
    if ($("#unit-commander").val() !== "") {
      $("#unit-commander").removeClass("is-invalid");
    }
  });

  $("#name-and-count").keyup(function() {
    if ($("#name-and-count").val() !== "") {
      $("#name-and-count").removeClass("is-invalid");
    }
  });

  $("#current-location").keyup(function() {
    if ($("#current-location").val() !== "") {
      $("#current-location").removeClass("is-invalid");
    }
  });

  $("#contact-person").keyup(function() {//
    if ($("#contact-person").val() !== "") {
      $("#contact-person").removeClass("is-invalid");
    }
  });//

  // валідація поля електронної пошти при введенні значення
  $("#email").keyup(function() {
    if ($("#email").val() !== "") {
      let email = $("#email").val();
      let emailRegex = /^\S+@\S+\.\S+$/;
      if (emailRegex.test(email)) {
        $("#email").removeClass("is-invalid");
      }
    }
  });

  $("#person-number").keyup(function() {
    if ($("#person-number").val() !== "") {
      let personNumber = $("#person-number").val();
      let personNumberRegex = /^\+380\d{9}$/;
      if (personNumberRegex.test(personNumber)) {
        $("#person-number").removeClass("is-invalid");
      }
    }
  });
});

//end of validation block

function copyToClipboard(text) {
  const input = $('<input>').val(text);
  $('body').append(input);
  input.select();
  document.execCommand('copy');
  input.remove();
  const message = $('<div>').text('Скопійовано в буфер обміну!').css({
    'position': 'fixed',
    'top': '50%',
    'left': '50%',
    'transform': 'translate(-50%, -50%)',
    'background-color': '#090808',
    'color': '#fff',
    'padding': '20px 100px',
    'border-radius': '5px',
    'z-index': '9999'
  }).appendTo('body');
  setTimeout(() => {
    message.fadeOut(() => {
      message.remove();
    });
  }, 2000);
}