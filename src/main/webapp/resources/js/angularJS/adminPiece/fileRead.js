/*function ReadFile(progressClassName, progressBarId, inputFileId){

    this.reader = new FileReader();
    this.progress = document.querySelector('.' + progressClassName);//percent

    this.abortRead = function () {
        this.reader.abort();
    }

    this.errorHandler = function (evt) {
        switch(evt.target.error.code) {
          case evt.target.error.NOT_FOUND_ERR:
            console.log('File Not Found!');
            break;
          case evt.target.error.NOT_READABLE_ERR:
            console.log('File is not readable');
            break;
          case evt.target.error.ABORT_ERR:
            break; // noop
          default:
            console.log('An error occurred reading this file.');
        };
    }

    this.updateProgress = function(evt) {
        // evt is an ProgressEvent.
        if (evt.lengthComputable) {
          var percentLoaded = Math.round((evt.loaded / evt.total) * 100);
          // Increase the progress bar length.
          if (percentLoaded < 100) {
            this.progress.style.width = percentLoaded + '%';
            this.progress.textContent = percentLoaded + '%';
          }
        }
    }

    this.handleFileSelect = function(evt) {
        // Reset progress indicator on new file selection.
        this.progress = document.querySelector('.' + progressClassName);//percent
        this.progress.style.width = '0%';
        this.progress.textContent = '0%';

        //this.reader = new FileReader();
        this.reader.onerror = this.errorHandler;
        this.reader.onprogress = this.updateProgress;
        this.reader.onabort = function(e) {
          console.log('File read cancelled');
        };
        this.reader.onloadstart = function(e) {
          document.getElementById(progressBarId).className = 'loading';//progress_bar
        };
        this.reader.onload = function(e) {
          // Ensure that the progress bar displays 100% at the end.
          this.progress = document.querySelector('.' + progressClassName);//percent
          this.progress.style.width = '100%';
          this.progress.textContent = '100%';
          setTimeout("document.getElementById('" + progressBarId + "').className='';", 2000);
        }

        // Read in the image file as a binary string.
        this.reader.readAsBinaryString(evt.target.files[0]);
    }

}
*/
/*V2*/
/*
var fileReader = {

    progressClassName : "",
    progressBarId : "",
    inputFileId : "",
    reader : new FileReader(),
    progress : "",//percent

    setProgressClassName : function(progressClassName){
      progressClassName = progressClassName;
      document.querySelector('.' + progressClassName)
    },

    setProgressBarId : function(progressBarId){
      progressBarId = progressBarId;
    },

    handleFileSelect : function(evt) {
        // Reset progress indicator on new file selection.
        //this.progress = document.querySelector('.' + progressClassName);//percent
        progress.style.width = '0%';
        progress.textContent = '0%';

        //reader = new FileReader();
        this.reader.onerror = this.errorHandler;
        this.reader.onprogress = this.updateProgress;
        this.reader.onabort = function(e) {
          console.log('File read cancelled');
        };
        this.reader.onloadstart = function(e) {
          document.getElementById(this.progressBarId).className = 'loading';//progress_bar
        };
        this.reader.onload = function(e) {
          // Ensure that the progress bar displays 100% at the end.
          this.progress = document.querySelector('.' + this.progressClassName);//percent
          this.progress.style.width = '100%';
          this.progress.textContent = '100%';
          setTimeout("document.getElementById('" + this.progressBarId + "').className='';", 2000);
        }

        // Read in the image file as a binary string.
        this.reader.readAsBinaryString(evt.target.files[0]);
    },

    setInputFileId : function(inputFileId){
      inputFileId = inputFileId;
      document.getElementById(inputFileId).addEventListener('change', handleFileSelect, false);//files
    },

    abortRead : function () {
        this.reader.abort();
    },

    errorHandler : function (evt) {
        switch(evt.target.error.code) {
          case evt.target.error.NOT_FOUND_ERR:
            console.log('File Not Found!');
            break;
          case evt.target.error.NOT_READABLE_ERR:
            console.log('File is not readable');
            break;
          case evt.target.error.ABORT_ERR:
            break; // noop
          default:
            console.log('An error occurred reading this file.');
        };
    },

    updateProgress : function(evt) {
        // evt is an ProgressEvent.
        if (evt.lengthComputable) {
          var percentLoaded = Math.round((evt.loaded / evt.total) * 100);
          // Increase the progress bar length.
          if (percentLoaded < 100) {
            this.progress.style.width = percentLoaded + '%';
            this.progress.textContent = percentLoaded + '%';
          }
        }
    },

    //el : document.getElementById(this.inputFileId).addEventListener('change', this.handleFileSelect, false)//files

}

*/
/*3*/

    var reader;
    var progress = document.querySelector('.percent');

    function abortRead() {
        reader.abort();
    }

    function errorHandler(evt) {
        switch(evt.target.error.code) {
            case evt.target.error.NOT_FOUND_ERR:
            alert('File Not Found!');
            break;
        case evt.target.error.NOT_READABLE_ERR:
            alert('File is not readable');
            break;
        case evt.target.error.ABORT_ERR:
            break; // noop
            default:
            alert('An error occurred reading this file.');
        };
    }

    function updateProgress(evt) {
    // evt is an ProgressEvent.
        if (evt.lengthComputable) {
            var percentLoaded = Math.round((evt.loaded / evt.total) * 100);
            // Increase the progress bar length.
            if (percentLoaded < 100) {
                progress.style.width = percentLoaded + '%';
                progress.textContent = percentLoaded + '%';
            }
        }
    }

    function handleFileSelect(evt) {
    // Reset progress indicator on new file selection.
        progress.style.width = '0%';
        progress.textContent = '0%';

        reader = new FileReader();
        reader.onerror = errorHandler;
        reader.onprogress = updateProgress;

        reader.onabort = function(e) {
            alert('File read cancelled');
        };

        reader.onloadstart = function(e) {
            document.getElementById('progress_bar').className = 'loading';
        };
        reader.onload = function(e) {
        // Ensure that the progress bar displays 100% at the end.
        progress.style.width = '100%';
        progress.style.display = 'block';
        progress.textContent = '100%';
        setTimeout("document.getElementById('progress_bar').className='';", 2000);
    }

        // Read in the image file as a binary string.
        reader.readAsBinaryString(evt.target.files[0]);
    }

    document.getElementById('files').addEventListener('change', handleFileSelect, false);