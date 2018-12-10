function checkValue(form, msg) {
    
    var userInput = form[form.id + ":username"];
    
    if(userInput.value == ''){
        alert(msg);
        userInput.focus();
        return false;
    }
    return true;
}

function showProgress(data) {
    if (data.status == 'begin') {
        document.getElementById('loading_wrapper').style.display = 'block';
    } else if (data.status == 'success') {
        document.getElementById('loading_wrapper').style.display = 'none';
    }
}



