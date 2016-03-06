package chapter_18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 打印目录
 * Created by KaiLee on 2016/3/6.
 */
public class DirList {
    public static void main(String[] args){
        File path = new File("D:/");
        String[] list;
        if(args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
        File dir = new File("D:/kai/nan");
        if(!dir.exists())
            dir.mkdirs();   //mkdirs和mkdir的区别
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).find();
    }
}
