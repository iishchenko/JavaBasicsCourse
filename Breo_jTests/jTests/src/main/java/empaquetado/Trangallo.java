package empaquetado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/************************************************************************
 * Created: 13/04/2018                                                  *
 * Author: Breogan Costa                                                *
 ************************************************************************/

@AllArgsConstructor
public class Trangallo {

  @Getter
  @Setter
  private float lenghtCm;
  @Getter
  @Setter
  private float heightCm;
  @Getter
  @Setter
  private float containerCapacityCC;
}
