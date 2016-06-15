package com.mtsmda.souvenir.spring.validation.validators.sequence;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * Created by dminzat on 5/12/2016.
 */
@GroupSequence({Default.class, FirstSequence.class, SecondSequence.class, ThirdSequence.class})
public interface SouvenirSequence {
}
