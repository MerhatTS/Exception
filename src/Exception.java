public class Exception {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик");
        dog.putCollar();
        dog.putMuzzle();
        try {
            dog.walk();
        }catch (DogIsNotReadyException ex){
            System.out.println(ex.getMessage());
            System.out.println("Проверяем снаряжение!, Ошейник надет? "+dog.isCollarPutOn+
                    "\nповодок надет? "+dog.isLeashPutOn+"\nнамардник надет? "+
                    dog.isMuzzlePutOn);
        }
    }
}

class Dog {
    String name;
    boolean isCollarPutOn;
    boolean isLeashPutOn;
    boolean isMuzzlePutOn;

    public Dog(String name){
        this.name = name;
    }

    public void putCollar(){
        System.out.println("Ошейник надет");
        this.isCollarPutOn= true;
    }

    public void putLeash(){
        System.out.println("Поводок надет");
        this.isLeashPutOn = true;
    }

    public void putMuzzle(){
        System.out.println("Намордник надет");
        this.isMuzzlePutOn = true;
    }

    public void walk() throws DogIsNotReadyException {
        System.out.println("Собираемся на прогулку");
        if (isCollarPutOn && isLeashPutOn && isMuzzlePutOn){
            System.out.println("Ура идем гулять "+name+" очень рад");
        }else {
            throw new DogIsNotReadyException("Собака "+name+" не готов к прогулке! Проверьте экипировку");
        }
    }
}

class DogIsNotReadyException extends java.lang.Exception {
        public DogIsNotReadyException(String massage){
            super(massage);
    }
}