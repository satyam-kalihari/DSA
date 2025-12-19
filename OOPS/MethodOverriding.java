public class MethodOverriding {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal();
        Animal dogInstance = new Dog(); // Polymorphism in action
        Animal catInstance = new Cat();

        System.out.print("Generic animal says: ");
        genericAnimal.speak();

        System.out.print("Dog says: ");
        dogInstance.speak(); 

        System.out.print("Cat says: ");
        catInstance.speak();
    }
}

class Animal {
    public void speak() {
        System.out.println("The animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}


