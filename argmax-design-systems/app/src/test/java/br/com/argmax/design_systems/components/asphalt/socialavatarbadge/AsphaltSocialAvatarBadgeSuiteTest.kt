package br.com.argmax.design_systems.components.asphalt.socialavatarbadge

import br.com.argmax.design_systems.components.asphalt.socialavatarbadge.context.*
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AsphaltSocialAvatarBadgeWithLabelAndInvalidUrlTest::class,
    AsphaltSocialAvatarBadgeWithOneValidUrlAndLabelTest::class,
    AsphaltSocialAvatarBadgeWithTwoValidUrlAndLabelTest::class
)
class AsphaltSocialAvatarBadgeSuiteTest