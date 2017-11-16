new Clipboard(".fw-code-copy-button", {
    text: function(trigger) {
        return $(trigger).parent().find('div').first().text();
    }
});