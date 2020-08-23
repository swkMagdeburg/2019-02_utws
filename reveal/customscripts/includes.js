var includeFiles = require('./fileInclude.js');
var renderPuml = require('./pumlpreprocessor.js');

module.exports = (markdown, options) => {
    return new Promise((resolve, reject) => {
        return resolve(
            renderPuml(includeFiles(markdown))
        );
    })
}
