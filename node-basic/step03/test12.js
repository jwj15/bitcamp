function Calculator() {
    this.result = 0;
    this.plus = function(value) {
        this.result += value;
    };
    this.minus = function(value) {
        this.result -= value;
    };
}

var c1 = new Calculator();

c1.plus(10);
c1.plus(20);
c1.minus(7);
console.log(c1.result);












