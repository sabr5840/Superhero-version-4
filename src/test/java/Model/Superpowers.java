package Model;

public class Superpowers {

        //Field of attributes
        private int id;
        private Superhero superhero;
        private Superpower superpower;

         //Constructor
        public Superpowers(int id, Superhero superhero, Superpower superpower) {
        this.id = id;
        this.superhero = superhero;
        this.superpower = superpower;
        }

        //Getter and setter
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Superhero getSuperhero() {
            return superhero;
        }

        public void setSuperhero(Superhero superhero) {
            this.superhero = superhero;
        }

        public Superpower getSuperpower() {
            return superpower;
        }

        public void setSuperpower(Superpower superpower) {
            this.superpower = superpower;
        }
}
