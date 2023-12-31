window.addEventListener('load', function () {
    (function(){

      const url = '/odontologos';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {

         for(odontologo of data){

            var table = document.getElementById("odontologosTable");
            var odontologoRow =table.insertRow();
            let tr_id = 'tr_' + odontologo.id;
            odontologoRow.id = tr_id;

            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                      ' type="button" onclick="deleteBy('+odontologo.id+')" class="btn btn-danger btn_delete">' +
                                      'Eliminar' +
                                      '</button>';


            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                      ' type="button" onclick="findBy('+odontologo.id+')" class="btn btn-info btn_id">' +
                                      'Actualizar' +
                                      '</button>';

            odontologoRow.innerHTML =

                    '<td class=\"td_id\">' + odontologo.id + '</td>' +
                    '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_nombre\">' + odontologo.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_nombre\">' + odontologo.matricula.toUpperCase() + '</td>' +
                    '<td>' + deleteButton + '</td>' +
                    '<td>' + updateButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/get_all_odontologos.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })

    })
