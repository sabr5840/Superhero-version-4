package Model;

public class Superpowers {

        private int id;
        private Superhero superhero;
        private Superpower superpower;

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
