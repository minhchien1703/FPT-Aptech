// Hàm để gọi API của Google
function callGoogleAPI() {
    fetch('https://www.googleapis.com/some-api-endpoint')
      .then(response => response.json())
      .then(data => {
        // display on tag
        document.getElementById('result').innerHTML = JSON.stringify(data, null, 2);
      })
      .catch(error => {
        console.error('Error:', error);
      });
  }
  
  // Gọi API mỗi 1 giây
  setInterval(callGoogleAPI, 1000);