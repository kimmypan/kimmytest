function genStatusTextColor(cellvalue, options, rowObject) {
    if (cellvalue) {
        return cellvalue + "(<span style='color: red'>" + rowObject.overdueDays + "</span>)";
    } else {
        return '';
    }
}