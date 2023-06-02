import axios from "axios";

class ImportService {

    uploadFileSevice(formData) {
        axios.post('http://localhost:8080/api/uploadDB', formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        })
            .then(response => {
                console.log(response.data);
            })
            .catch(error => {
                console.log(error);
            });
    }



}

export default new ImportService();