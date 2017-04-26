/*Standard javascript for zeWag Application
2016 - Written by TNA for SC2016.09
*/

function CallOneUser(value,successMethod)
{   		
	var webServiceURL = 'http://localhost:8080/MongoDBSPRG/zeWag/rs/getOneUser' ;	
	var params = value ;
	
    $.ajax({
    	xhrFields: {
    	    withCredentials: true
    	},
    	cache : false,
        url: webServiceURL, 
        data: params ,
        type: "POST",
        dataType: 'json',
        contentType: "application/json",
        process : false ,
        success: successMethod, 
        error: OnErrorStd
    });
    return false;
}

function OnErrorStd(data, status, error)
{
// A Label sysMsg must be defined on the body of HTML Document
	   if ( data.msg != null ){
		   document.getElementById('sysMsg').innerHTML = data.msg ;
	   }else{
	      alert('ERROR status :'+status+ ' error :'+error);
	   }   
}

function OnSuccessStd(data, status)
{
// A Label sysMsg must be defined on the body of HTML Document
	   if ( data.msg != null ){
		   document.getElementById('sysMsg').innerHTML = data.msg ;
	   }
}

/**
 * Specific Call to Service to get Picture of Profile
 * @param value : OID passed
 * @param successMethod : Method to call if Success
 * @returns : false
 */
function CallServiceProfil(value, successMethod)
{   	
//     alert('CallServiceFilePP');
    var p = { uoid :  value } ;
    
    var params = value ;
	var webServiceURL = 'http://localhost:8080/MongoDBSPRG/zeWag/rs/getProfilPicture' ;
	
	$.ajax({
    	cache : false,
        url: webServiceURL, 
        data: params,
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        process : false ,
        success: successMethod, 
        error: OnErrorStd
    });
    
    return false;
}


function getFileExtension(fileName) {
	var fileExtension;
	fileExtension = fileName.substr((fileName.lastIndexOf('.') + 1));
	return fileExtension;
}

/**
 * More efficient Binary conversion (Encode Base64 )
 * @param buffer : Data
 * @returns : btoa Buffer
 */
function arrayBufferToBase64( buffer ) {
    var binary = '';
    var bytes = new Uint8Array( buffer );
    var len = bytes.byteLength;
    for (var i = 0; i < len; i++) {
        binary += String.fromCharCode( bytes[ i ] );
    }
    return window.btoa( binary );
}

/**
 * More efficient Binary conversion ( DEcode Base64 )
 * @param buffer : Data
 * @returns : btoa Buffer
 */
function base64ToArrayBuffer(base64) {
    var binary_string =  window.atob(base64);
    var len = binary_string.length;
    var bytes = new Uint8Array( len );
    for (var i = 0; i < len; i++)        {
        bytes[i] = binary_string.charCodeAt(i);
    }
    return bytes.buffer;
}

//Get Browser Type

function GetBrowser(){
    return  navigator ? navigator.userAgent.toLowerCase() : "other";
}

function setCustomColor(zone,color1,color2){
	var canvas = document.getElementById(zone);
	var context = canvas.getContext('2d');
	context.beginPath();
	var grd = context.createLinearGradient(0, 0, canvas.width, canvas.height);
	// Fill
     context.fillStyle = grd ;
     context.fill();
     grd.addColorStop(0, '#8ED6FF');   
     // dark blue
     grd.addColorStop(1, '#004CB3');
     context.fillStyle = grd;
 	 context.lineWidth = 5;	
     context.fill();
     context.strokeStyle = '#151515';
 	 context.stroke();
}

function drawPBarCircle(zone, evol, indice) {
	var canvas = document.getElementById(zone);
	var context = canvas.getContext('2d');
	var x = ( canvas.width  ) / 2;
	var y = ( canvas.height ) / 2;
	var radius = x ;
	var startAngle = 1.5000 * Math.PI;
	var endAngle = ( 1.5000 * evol ) * Math.PI ;
	var counterClockwise = false;
//    console.log('evol ['+indice+'] :'+endAngle+' evol:'+evol+' angle:'+( 1.5000 * evol )) ;
	context.beginPath();
	context.arc(x, y, radius, startAngle, endAngle, counterClockwise);
	var grd = context.createLinearGradient(0, 0, canvas.width, canvas.height);
	// Fill
     context.fillStyle = grd ;
     context.fill();
    // light blue
    grd.addColorStop(0, '#8ED6FF');   
    // dark blue
    grd.addColorStop(1, '#004CB3');
    context.fillStyle = grd;
	context.lineWidth = 5;	
    context.fill();
	// line color
	context.strokeStyle = '#151515';
	context.stroke();
}