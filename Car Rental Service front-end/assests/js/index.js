function myFunction() {
    var x = document.getElementById("password");
    if (($("#checkbox").checked) === true) {
        $("#password").type = "password";
    } else {
        $("#password").type = "text";
    }

}

// *************
$(function () {
    $(".btn").click(function () {
        $(".form-signin").toggleClass("form-signin-left");
        $(".form-signup").toggleClass("form-signup-left");
        $(".frame").toggleClass("frame-long");
        $(".signup-inactive").toggleClass("signup-active");
        $(".signin-active").toggleClass("signin-inactive");
        $(".forgot").toggleClass("forgot-left");
        $(this).removeClass("idle").addClass("active");
    });
});


// ****************

$(function () {
    $(".btn-signup").click(function () {

        let id = $('#cusID').val();
        let name = $('#name').val();
        let email = $('#email').val();
        let contact = $('#contact').val();
        let address = $('#address').val();
        let licenseNo = $('#licenseNo').val();
        let nicNo = $('#nicNo').val();
        let pw = $('#confirmpassword').val();

        $.ajax({
            method: 'POST',
            url: "http://localhost:8080/Car_Rental_Service_Project_war_exploded/customer",
            contentType: 'application/json',
            async: true,
            data: JSON.stringify({
                cusID: id,
                name: name,
                email: email,
                contact: contact,
                address: address,
                licenseNo: licenseNo,
                nicNo: nicNo,
                pw: pw


            }),
            success: function (data) {
                $('#modalsignup1').modal('hide');
                console.log(data);

            }
        });


    });
});

var temp;

$(function () {
    $(".btn-signin").click(function () {

        let id = $('#username').val();
        let pw = $('#password').val();


        $.ajax({
            method: 'GET',
            url: `http://localhost:8080/Car_Rental_Service_Project_war_exploded/customer/search/${id}`,
            async: true,

            success: function (resp) {
                let response = resp.data

                if (response.pw === pw) {
                    temp = response.pw;
                    $('#modalsignup1').modal('hide');
                    window.location = "customer.html";

                    $('#cID').text(response.pw);
                    loadCusId();

                } else {
                    alert("password doesn't match");
                }


            },


        });


    });
});

// setInterval(function () {
//
//         console.log("function eka call una")
//         $('#cID').text(temp);
//     },
//
//     3000);


function loadCusId() {
    console.log("loadcusID eka call una")
    $('#cID').text(temp);
}

$('#cusID').on('keydown', function (event) {
    console.log("hi")
})


// ************ADMIN********************


$(function () {

    $.ajax({
        method: 'GET',
        url: `http://localhost:8080/Car_Rental_Service_Project_war_exploded/customer/getAll/`,
        async: true,

        success: function (resp) {
            let response = resp.data;

            var count = 0;
            for (var i in response) {
                let cusId = (response[i].cusID)
                let name = (response[i].name)
                let email = (response[i].email)
                let contact = (response[i].contact)
                let address = (response[i].address)
                let lID = (response[i].licenseNo)
                let nIC = (response[i].nicNo)
                let pw = (response[i].pw)
                count++;

                var row = `<tr><td>${cusId}</td><td>${name}</td><td>${email}</td><td>${contact}</td><td>${address}</td><td>${lID}</td><td>${nIC}</td><td>${pw}</td></tr>`;
                $('#customer-table').append(row);


            }

            $('#cutomer-count').text(count);


        },


    });


});

$(function () {

    $.ajax({
        method: 'GET',
        url: `http://localhost:8080/Car_Rental_Service_Project_war_exploded/booking/getAll`,
        async: true,

        success: function (resp) {
            let response = resp.data;

            var count = 0;
            for (var i in response) {
                let id = (response[i].id)
                let driver = (response[i].driver)
                let pickupDate = (response[i].pickupDate)
                let returnDate = (response[i].returnDate)
                let location = (response[i].location)
                let permission = (response[i].permission)
                let customer = (response[i].customer.cusID)
                let car = (response[i].car.id)
                let driver_ID = (response[i].driver_ID.id)

                count++;


                var row = `<tr><td>${id}</td>
                            <td>${driver}</td>
                            <td>${pickupDate}</td>
                            <td>${returnDate}</td>
                            <td>${location}</td>
                            <td>${permission}</td>
                            <td>${customer}</td>
                            <td>${car}</td>
                            <td>${driver_ID}</td></tr>`;
                $('#booking-table').append(row);


            }

            $('#booking-count').text(count);


        },


    });


});

$(function () {

    $.ajax({
        method: 'GET',
        url: `http://localhost:8080/Car_Rental_Service_Project_war_exploded/car/getAll`,
        async: true,

        success: function (resp) {
            let response = resp.data;
                console.log(response);
            var count = 0;
            for (var i in response) {
                let id = (response[i].id)
                let name = (response[i].name)
                let brand = (response[i].brand)
                let color = (response[i].color)
                let type = (response[i].type)
                let passengers = (response[i].passengers)
                let transmission_Type = (response[i].transmission_Type)
                let number = (response[i].number)
                let fuelType = (response[i].fuelType)
                let dailyRate = (response[i].dailyRate)
                let free_Mileage_day = (response[i].free_Mileage_day)
                let monthlyRate = (response[i].monthlyRate)
                let free_Mileage_month = (response[i].free_Mileage_month)
                let extraKmPrice = (response[i].extraKmPrice)


                count++;


                var row = `<tr><td>${id}</td>
                            <td>${name}</td>
                            
                            <td>${brand}</td>
                            <td>${color}</td>
                            <td>${type}</td>
                            <td>${passengers}</td>
                            <td>${transmission_Type}</td>
                            <td>${number}</td>
                            <td>${fuelType}</td>
                            <td>${dailyRate}</td>
                            <td>${free_Mileage_day}</td>
                            <td>${monthlyRate}</td>
                            <td>${free_Mileage_month}</td>
                            <td>${extraKmPrice}</td>
                            </tr>`;
                $('#car-table').append(row);


            }

            $('#car-count').text(count);


        },


    });


});


// ***************END ADMIN*************