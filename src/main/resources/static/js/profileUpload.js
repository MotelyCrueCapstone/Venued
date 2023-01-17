const client = filestack.init(AaB6NdU8UT2NoIG66Qc1Jz);

client.picker().open();
const options = {
    fromSources: ["local_file_system","instagram","facebook"],
    uploadConfig: {
        retry: 5,
        timeout: 60000
    },
    onFileUploadFinished(file) {
        console.log(file);
    }
};
client.picker(options).open();