import org.junit.jupiter.api.Test;

// gradle에서는 기본적으로 src/test/java 폴더를 test파일의 소스 경로로 인식
// : java 폴더 내의 하위 테스트 클래스에는 static import를 사용하여 assertions의 메소드를 직접 호출
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AssertJTest {
    @Test
    public void assertJTest(){
        String name1= "lsa";
        String name2= "ldk";
        String name3= "kmj";

        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        //assertThat(name1).isEqualTo(name2);

        //assertThat(name1).isNotEqualTo(name3);
    }
}
