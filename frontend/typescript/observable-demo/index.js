"use strict";
exports.__esModule = true;
var rxjs_1 = require("rxjs");
var observableObj = (0, rxjs_1.of)("apple", "mango", "banana");
var observer = {
    next: function (result) {
        console.log("result is " + result);
    },
    error: function (err) {
        console.log("error is " + err);
    },
    complete: function () {
        console.log("completed");
    }
};
observableObj.subscribe(observer);
