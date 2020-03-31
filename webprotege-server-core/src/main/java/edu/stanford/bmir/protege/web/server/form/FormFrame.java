package edu.stanford.bmir.protege.web.server.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.auto.value.AutoValue;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import edu.stanford.bmir.protege.web.shared.entity.*;
import edu.stanford.bmir.protege.web.shared.form.FormSubjectFactoryDescriptor;
import edu.stanford.bmir.protege.web.shared.form.data.FormData;
import edu.stanford.bmir.protege.web.shared.form.data.FormEntitySubject;
import edu.stanford.bmir.protege.web.shared.form.data.FormIriSubject;
import edu.stanford.bmir.protege.web.shared.form.data.FormSubject;
import edu.stanford.bmir.protege.web.shared.frame.ClassFrame;
import edu.stanford.bmir.protege.web.shared.frame.EntityFrame;
import edu.stanford.bmir.protege.web.shared.frame.PropertyValue;
import org.semanticweb.owlapi.model.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-01-13
 *
 * Represents the translation of form data into frame data
 */
@AutoValue
@GwtCompatible(serializable = true)
public abstract class FormFrame {

    @Nonnull
    public static FormFrame get(@Nonnull FormSubject formSubject,
                                @Nonnull ImmutableSet<OWLClassData> parents,
                                @Nonnull ImmutableSet<OWLNamedIndividualData> instances,
                                @Nonnull ImmutableSet<PropertyValue> propertyValues,
                                @Nonnull ImmutableSet<FormFrame> nestedFrames) {
        return new AutoValue_FormFrame(formSubject, parents, instances, propertyValues, nestedFrames);
    }

    @Nonnull
    public static FormFrame get(@Nonnull FormSubject formSubject) {
        return get(formSubject,
                   ImmutableSet.of(),
                   ImmutableSet.of(),
                   ImmutableSet.of(),
                   ImmutableSet.of());
    }

    @Nonnull
    public abstract FormSubject getSubject();

    @Nonnull
    public abstract ImmutableSet<OWLClassData> getClasses();

    @Nonnull
    public abstract ImmutableSet<OWLNamedIndividualData> getInstances();

    @Nonnull
    public abstract ImmutableSet<PropertyValue> getPropertyValues();

    @Nonnull
    public abstract ImmutableSet<FormFrame> getNestedFrames();
}
