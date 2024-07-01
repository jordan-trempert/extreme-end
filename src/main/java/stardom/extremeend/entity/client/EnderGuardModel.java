package stardom.extremeend.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import stardom.extremeend.entity.animation.ModAnimations;
import stardom.extremeend.entity.custom.EnderGuardEntity;

// Made with Blockbench 4.10.0
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class EnderGuardModel<T extends EnderGuardEntity>  extends SinglePartEntityModel<T> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;

	public EnderGuardModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("body").getChild("head");
		this.rightArm = root.getChild("body").getChild("rightArm");
		this.leftArm = root.getChild("body").getChild("leftArm");
		this.rightLeg = root.getChild("body").getChild("rightLeg");
		this.leftLeg = root.getChild("body").getChild("leftLeg");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(48, 26).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(6, 0).cuboid(-4.0F, -8.0F, -9.0F, 8.0F, 8.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rightArm = body.addChild("rightArm", ModelPartBuilder.create().uv(56, 6).cuboid(-5.0F, -7.0F, -3.0F, 6.0F, 30.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

		ModelPartData rightItem = rightArm.addChild("rightItem", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 21.0F, 1.0F));

		ModelPartData leftArm = body.addChild("leftArm", ModelPartBuilder.create().uv(58, 6).mirrored().cuboid(-1.0F, -7.0F, -3.0F, 5.0F, 30.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 0).cuboid(1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

		ModelPartData rightLeg = body.addChild("rightLeg", ModelPartBuilder.create().uv(64, 10).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));

		ModelPartData leftLeg = body.addChild("leftLeg", ModelPartBuilder.create().uv(64, 10).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, 12.0F, 0.0F));
		return TexturedModelData.of(modelData, 80, 42);
	}
	@Override
	public void setAngles(EnderGuardEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.ENDER_GUARD_MOVE, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.ENDER_GUARD_BOB, ageInTicks, 1);

	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}


	@Override
	public ModelPart getPart() {
		return body;
	}
}