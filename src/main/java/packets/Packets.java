package packets;

import java.io.Serializable;

public interface Packets {

    public class Shot implements Serializable {

        private Integer width;
        private Integer length;

        public Shot(Integer width, Integer length) {
            this.width = width;
            this.length = length;
        }

        public Integer getWidth() {
            return width;
        }

        public Integer getLength() {
            return length;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Shot packet ").append("width: ").append(width).append(" length: ").append(length);
            return sb.toString();
        }

    }


    public class Ok implements Serializable {

        public String toString() {
            return "Ok packet";
        }
    }

}
