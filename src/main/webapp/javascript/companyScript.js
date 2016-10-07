$(document).ready(function () {

    getCompanies();

    function getCompanies() {

        $('#companybody').html("");

        $.ajax({
            url: 'http://localhost:8084/CA2REST/api/company/complete',
            type: "GET",
            dataType: "json",
            success: function (m) {
                m.forEach(function (company) {
                    var coutput = "";
                    coutput += typeof company.name !== "undefined" ? '<td>' + company.name + '</td>' : '<td>-</td>';
                    coutput += typeof company.email !== "undefined" ? '<td>' + company.email + '</td>' : '<td>-</td>';
                    coutput += typeof company.description !== "undefined" ? '<td>' + company.description + '</td>' : '<td>-</td>';
                    coutput += typeof company.cvr !== "undefined" ? '<td>' + company.cvr + '</td>' : '<td>-</td>';
                    coutput += typeof company.numEmployees !== "undefined" ? '<td>' + company.numEmployees + '</td>' : '<td>-</td>';
                    coutput += typeof company.marketValue !== "undefined" ? '<td>' + company.marketValue + '</td>' : '<td>-</td>';
                    $('#companybody').append('<tr>' + coutput + '</tr>');
                });
            }, error: function (res) {
                console.log(res);
            }
        });
    }

    $("#addCompany").click(function (data) {
        var name = $("#companyName").val();
        var description = $("#companyDescription").val();
        var email = $("#companyEmail").val();
        var cvr = $("#companyCVR").val();
        var employees = $("#companyEmployees").val();
        var marketValue = $("#companyMarketValue").val();
//        var street = $("#companyStreet").val();
//        var zipcode = $("#companyZipcode").val();
//        var city = $("#companyCity").val();

        $.ajax({
            url: "http://localhost:8084/CA2REST/api/company",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                name: name,
                description: description,
                email: email,
                cvr: cvr,
                numEmployees: employees,
                marketValue: marketValue,
//                street: street,
//                zipcode: zipcode,
//                city: city
            }),
            success: function (person) {
                getCompanies();
            }, error: function (res) {
                console.log(res);
            }
        });


    });

    $("#delete").click(function (data) {
        var ID = $("#ID").val();
        $.ajax({
            url: "http://localhost:8084/CA2REST/api/person/" + ID,
            type: "DELETE",
            success: function (data) {
                getPersonsComplete();
                getPersonsContact();
            }, error: function (res) {
                console.log(res);
            }
        });
    });

});

