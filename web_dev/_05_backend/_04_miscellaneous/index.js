class Person {
    constructor(name, age) {
        this.name = name ;
        this.age = age ;
    }

    talk() {
        console.log(`Hello, I'm ${this.name}`) ;
    }
}

p1 = new Person('Adam', 23) ;
p1.talk() ;

p2 = new Person('Catlyn', 25) ;
p2.talk() ;