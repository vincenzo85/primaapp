package androidservice.com.myapplication.Sqlite;

/**
 * Created by Utente on 26/07/2016.
 */
public class Post {



        private int id;
        private String type;
        private String post;

        public Post (int id, String type, String post)

        {

            this.setId(id);
            this.setType(type);
            this.setPost(post);



        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }
    }


