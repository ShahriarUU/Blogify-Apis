package com.example.Blogify.constant;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DbConstant {

    public static class DbCommon {

        public static final String CREATED_ON = "create_on";
        public static final String LAST_UPDATED_ON = "last_updated_on";
        public static final String ID = "id";


        DbCommon() {
        }

    }

    public static class DbUser extends DbCommon {
        public static final String TABLE_NAME = "users";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String ROLE = "user_role";

        DbUser() {

        }
    }

    public static class DbUserProfile extends DbCommon {
        public static final String TABLE_NAME = "user_profile";
        public static final String NAME = "name";
        public static final String IMAGE = "image";
        public static final String ADDRESS = "address";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String PROFESSION = "profession";
        public static final String STATUS = "status";
        public static final String ABOUT = "about";
    }

    public static class DbBlogCategory extends DbCommon {
        public static final String TABLE_NAME = "categories";
        public static final String CATEGORY_NAME = "category";
    }

    public static class DbBlogPost extends DbCommon {
        public static final String TABLE_NAME = "posts";
        public static final String TITLE = "title";
        public static final String IMAGE = "image";
        public static final String CONTENT = "content";
    }

    public static class DbBlogComment extends DbCommon {
        public static final String TABLE_NAME = "comments";
        public static final String COMMENT = "comment";
    }

}
