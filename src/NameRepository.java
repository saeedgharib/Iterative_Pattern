public class NameRepository implements Container {
    public String names[] = {"Saeed", "Basit", "Huraira", "Haris"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }

        public boolean hasPrevious() {
            if (index > 0) {
                return true;
            }
            return false;
        }

        public Object previous() {
            if (this.hasPrevious()) {
                return names[--index];
            }
            return null;
        }

        public void moveToLast() {
            index = names.length - 1;
        }

        public void moveToFirst() {
            index = 0;
        }
    }
}