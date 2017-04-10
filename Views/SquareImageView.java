
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SquareImageView  extends ImageView {

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

      super.onMeasure(widthMeasureSpec, widthMeasureSpec);

  }

  public SquareImageView(Context context) {
    super(context);
  }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}