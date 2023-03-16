package Model;

public class Superpower {

         //Field of attributes
        private int id;
        private String name;

        //Constructor
        public Superpower(int id, String name) {
        this.id = id;
        this.name = name;
        }

        //Getter and setter
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
