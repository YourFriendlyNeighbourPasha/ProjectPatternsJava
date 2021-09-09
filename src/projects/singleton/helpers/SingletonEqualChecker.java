package projects.singleton.helpers;

import projects.singleton.models.DailyStatistics;
import projects.singleton.models.posts.Post;

public class SingletonEqualChecker {

    public static boolean checkSingletonForEqualityBetweenTwoPosts(Post firstPost, Post secondPost) {
        return firstPost.getStatistics() == secondPost.getStatistics();
    }

    public static boolean checkSingletonForEqualityWithGlobalAccessPoint(Post post) {
        return post.getStatistics() == DailyStatistics.getInstance();
    }

}
