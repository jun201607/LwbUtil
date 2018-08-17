package demo.lwb.com.myutils.bean;

public class Demo {

    @Override
    public String toString() {
        return "Demo{" +
                "id='" + id + '\'' +
                ", appid='" + appid + '\'' +
                ", name='" + name + '\'' +
                ", showtype='" + showtype + '\'' +
                ", showurl='" + showurl + '\'' +
                '}';
    }

    /**
         * id : 1
         * appid : App_98ef9c4f53e243f6bd3ce05d0acf9b52
         * name : 登录
         * showtype : login
         * showurl : aaaa
         */

        private String id;
        private String appid;
        private String name;
        private String showtype;
        private String showurl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShowtype() {
            return showtype;
        }

        public void setShowtype(String showtype) {
            this.showtype = showtype;
        }

        public String getShowurl() {
            return showurl;
        }

        public void setShowurl(String showurl) {
            this.showurl = showurl;
        }

}
