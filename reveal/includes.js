var includeFiles = require('./customscripts/fileInclude.js');
var renderPuml = require('./customscripts/pumlpreprocessor.js');

module.exports = (markdown, options) => {
    return new Promise((resolve, reject) => {
        return resolve(
            renderPuml(includeFiles(markdown))
        );
    })
}
