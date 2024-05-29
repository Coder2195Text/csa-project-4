package mod.coder2195.america.entity.client;

import mod.coder2195.america.entity.custom.M1A2Entity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class M1A2Model<T extends M1A2Entity> extends SinglePartEntityModel<T> {
  private final ModelPart tank;
  private final ModelPart turret;
  private final ModelPart barrel;

  public M1A2Model(ModelPart root) {
    this.tank = root.getChild("over_power");
    this.turret = tank.getChild("ulra_super").getChild("super_group").getChild("body_main").getChild("turret");
    this.barrel = turret.getChild("gun").getChild("barrel");
  }

   @SuppressWarnings("unused")
  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    ModelPartData over_power = modelPartData.addChild("over_power", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

   
    ModelPartData track_dust_owner = over_power.addChild("track_dust_owner", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -22.0F));

    ModelPartData ulra_super = over_power.addChild("ulra_super", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -18.0F, -6.0F));

    ModelPartData super_group = ulra_super.addChild("super_group", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 18.0F, -2.0F));

    ModelPartData body_main = super_group.addChild("body_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData turret = body_main.addChild("turret", ModelPartBuilder.create().uv(0, 0).cuboid(-16.0F, -10.5F, -10.4688F, 32.0F, 9.0F, 15.0F, new Dilation(0.0F))
        .uv(228, 244).cuboid(15.0782F, -10.3438F, -11.8699F, 2.0F, 9.0F, 14.0F, new Dilation(0.0F))
        .uv(247, 130).cuboid(17.0691F, -5.3417F, -11.9637F, 2.0F, 4.0F, 14.0F, new Dilation(0.0F))
        .uv(247, 130).mirrored().cuboid(-19.0691F, -5.3417F, -11.9637F, 2.0F, 4.0F, 14.0F, new Dilation(0.0F)).mirrored(false)
        .uv(34, 228).cuboid(-17.0782F, -10.3438F, -11.8699F, 2.0F, 9.0F, 14.0F, new Dilation(0.0F))
        .uv(247, 151).cuboid(-16.0F, -10.5F, 4.5313F, 32.0F, 5.0F, 24.0F, new Dilation(0.0F))
        .uv(115, 16).cuboid(-12.0F, -11.0F, 15.0313F, 24.0F, 1.0F, 14.0F, new Dilation(0.0F))
        .uv(147, 154).cuboid(-14.5F, -11.0F, -9.4688F, 9.0F, 1.0F, 9.0F, new Dilation(0.0F))
        .uv(306, 28).cuboid(-13.5F, -13.0F, -9.4688F, 7.0F, 2.0F, 8.0F, new Dilation(0.0F))
        .uv(0, 242).cuboid(1.0F, -10.5F, 28.4375F, 11.0F, 6.0F, 9.0F, new Dilation(0.0F))
        .uv(115, 182).cuboid(-12.0F, -10.5F, 28.5313F, 13.0F, 5.0F, 4.0F, new Dilation(0.0F))
        .uv(170, 105).cuboid(1.5F, -13.5F, 31.5313F, 10.0F, 3.0F, 7.0F, new Dilation(0.0F))
        .uv(295, 94).cuboid(-2.6562F, -21.375F, 31.8566F, 4.0F, 1.5F, 2.0F, new Dilation(-0.3F))
        .uv(91, 0).cuboid(2.0F, -13.0F, 38.0313F, 2.0F, 2.0F, 1.0F, new Dilation(0.2F))
        .uv(14, 60).cuboid(4.75F, -13.0F, 38.0313F, 2.0F, 2.0F, 1.0F, new Dilation(0.2F))
        .uv(87, 86).cuboid(8.75F, -12.0F, 38.0313F, 1.0F, 1.0F, 1.0F, new Dilation(0.2F))
        .uv(72, 65).cuboid(20.0F, -12.0F, 13.5313F, 1.0F, 8.0F, 9.0F, new Dilation(0.0F))
        .uv(72, 65).mirrored().cuboid(-21.0F, -12.0F, 13.5313F, 1.0F, 8.0F, 9.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 141).cuboid(16.0F, -10.5F, 1.5313F, 4.0F, 6.0F, 25.0F, new Dilation(0.0F))
        .uv(115, 31).cuboid(-20.0F, -10.5F, 1.5313F, 4.0F, 6.0F, 25.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -20.0F, 0.0F));

    ModelPartData turret_r1 = turret.addChild("turret_r1", ModelPartBuilder.create().uv(115, 62).cuboid(-16.0F, -52.1126F, -16.4738F, 31.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 44.1006F, -8.044F, -0.2618F, 0.0F, 0.0F));

    ModelPartData turret_r2 = turret.addChild("turret_r2", ModelPartBuilder.create().uv(384, 0).cuboid(-19.5F, -46.2249F, 19.718F, 39.0F, 3.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 42.1903F, 2.3683F, 0.1047F, 0.0F, 0.0F));

    ModelPartData turret_r3 = turret.addChild("turret_r3", ModelPartBuilder.create().uv(115, 74).cuboid(-15.5F, -45.0564F, 16.5607F, 31.0F, 3.5F, 3.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, 9.6495F, -15.0386F, -0.7854F, 0.0F, 0.0F));

    ModelPartData turret_r4 = turret.addChild("turret_r4", ModelPartBuilder.create().uv(133, 61).cuboid(-19.0312F, -40.5F, 16.1066F, 2.0F, 7.0F, 2.0F, new Dilation(-0.3F))
        .uv(152, 61).cuboid(-19.0312F, -34.0F, 16.1066F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 20.0F, 8.0F, 0.0F, 0.7854F, 0.0F));

    ModelPartData turret_r5 = turret.addChild("turret_r5", ModelPartBuilder.create().uv(115, 115).mirrored().cuboid(-26.7936F, -51.5374F, 39.0313F, 2.0F, 6.0F, 11.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-13.4973F, 47.5322F, -22.0F, 0.0F, 0.0F, 0.4363F));

    ModelPartData turret_r6 = turret.addChild("turret_r6", ModelPartBuilder.create().uv(115, 115).cuboid(24.7936F, -51.5374F, 39.0313F, 2.0F, 6.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(13.4973F, 47.5322F, -22.0F, 0.0F, 0.0F, -0.4363F));

    ModelPartData turret_r7 = turret.addChild("turret_r7", ModelPartBuilder.create().uv(115, 0).mirrored().cuboid(-29.325F, -48.6921F, -5.4688F, 1.0F, 4.0F, 6.0F, new Dilation(-0.2F)).mirrored(false)
        .uv(370, 0).mirrored().cuboid(-29.325F, -48.6921F, -5.4688F, 0.0F, 4.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
        .uv(115, 115).mirrored().cuboid(-28.6063F, -50.6921F, -8.4688F, 2.0F, 9.0F, 30.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-12.5755F, 47.6884F, -3.4012F, 0.0F, 0.0F, 0.4363F));

    ModelPartData turret_r8 = turret.addChild("turret_r8", ModelPartBuilder.create().uv(370, 0).cuboid(29.325F, -48.6921F, -5.4688F, 0.0F, 4.0F, 6.0F, new Dilation(0.0F))
        .uv(115, 0).cuboid(28.325F, -48.6921F, -5.4688F, 1.0F, 4.0F, 6.0F, new Dilation(-0.2F))
        .uv(115, 115).cuboid(26.6063F, -50.6921F, -8.4688F, 2.0F, 9.0F, 30.0F, new Dilation(0.0F)), ModelTransform.of(12.5755F, 47.6884F, -3.4012F, 0.0F, 0.0F, -0.4363F));

    ModelPartData turret_r9 = turret.addChild("turret_r9", ModelPartBuilder.create().uv(36, 176).mirrored().cuboid(7.0F, -52.3438F, -28.4688F, 15.0F, 9.0F, 9.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-6.4832F, 42.0F, 15.4654F, 0.0F, 0.6109F, 0.0F));

    ModelPartData turret_r10 = turret.addChild("turret_r10", ModelPartBuilder.create().uv(36, 176).cuboid(-22.0F, -52.3438F, -28.4688F, 15.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(6.4832F, 42.0F, 15.4654F, 0.0F, -0.6109F, 0.0F));

    ModelPartData turret_r11 = turret.addChild("turret_r11", ModelPartBuilder.create().uv(173, 175).cuboid(1.7929F, -58.5F, -11.1611F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F))
        .uv(115, 154).cuboid(0.7929F, -55.5F, -12.1611F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F))
        .uv(115, 132).cuboid(0.2929F, -54.5F, -12.6611F, 7.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 42.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

    ModelPartData blowout2 = turret.addChild("blowout2", ModelPartBuilder.create().uv(120, 231).cuboid(-11.0938F, -32.0F, 7.5313F, 11.0F, 1.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 20.0F, 8.0F));

    ModelPartData blowout1 = turret.addChild("blowout1", ModelPartBuilder.create(), ModelTransform.pivot(11.3125F, 20.0F, 44.0625F));

    ModelPartData blowout1_r1 = blowout1.addChild("blowout1_r1", ModelPartBuilder.create().uv(120, 231).cuboid(-0.0938F, -32.0F, 15.5313F, 11.0F, 1.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

    ModelPartData basket = turret.addChild("basket", ModelPartBuilder.create().uv(0, 3).cuboid(0.7436F, -47.5F, -3.8158F, 0.0F, 1.0F, 36.0F, new Dilation(0.0F))
        .uv(0, 3).mirrored().cuboid(-39.8814F, -47.5F, -3.8158F, 0.0F, 1.0F, 36.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 1).cuboid(0.7436F, -50.0F, -3.8158F, 0.0F, 1.0F, 36.0F, new Dilation(0.0F))
        .uv(0, 1).mirrored().cuboid(-39.8814F, -50.0F, -3.8158F, 0.0F, 1.0F, 36.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 30).cuboid(0.7436F, -52.5F, -3.8158F, 0.0F, 1.0F, 36.0F, new Dilation(0.0F))
        .uv(0, 30).mirrored().cuboid(-39.8814F, -52.5F, -3.8158F, 0.0F, 1.0F, 36.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(19.5689F, 42.0F, 5.3471F));

    ModelPartData basket_r1 = basket.addChild("basket_r1", ModelPartBuilder.create().uv(0, 0).cuboid(19.3125F, -47.5F, 1.5313F, 0.0F, 1.0F, 40.5938F, new Dilation(0.0F))
        .uv(0, 1).cuboid(19.3125F, -50.0F, 1.5313F, 0.0F, 1.0F, 40.5938F, new Dilation(0.0F))
        .uv(0, 2).cuboid(19.3125F, -52.5F, 1.5313F, 0.0F, 1.0F, 40.5938F, new Dilation(0.0F)), ModelTransform.of(2.2749F, 0.0F, 12.8727F, 0.0F, -1.5708F, 0.0F));

    ModelPartData basket_r2 = basket.addChild("basket_r2", ModelPartBuilder.create().uv(38, 31).mirrored().cuboid(-20.3125F, -49.5F, 30.5313F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.0014F, 2.0F, -0.0009F, 0.0F, -1.1345F, 0.0F));

    ModelPartData basket_r3 = basket.addChild("basket_r3", ModelPartBuilder.create().uv(38, 31).cuboid(20.3125F, -49.5F, 30.5313F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-39.1363F, 2.0F, -0.0009F, 0.0F, 1.1345F, 0.0F));

    ModelPartData basket_r4 = basket.addChild("basket_r4", ModelPartBuilder.create().uv(0, 26).mirrored().cuboid(-20.3125F, -50.5F, 30.5313F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 8).mirrored().cuboid(-20.3125F, -53.0F, 28.5313F, 0.0F, 1.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.5F, 0.0F, 0.0F, -1.1345F, 0.0F));

    ModelPartData basket_r5 = basket.addChild("basket_r5", ModelPartBuilder.create().uv(0, 26).cuboid(20.3125F, -50.5F, 30.5313F, 0.0F, 1.0F, 4.0F, new Dilation(0.0F))
        .uv(0, 8).cuboid(20.3125F, -53.0F, 28.5313F, 0.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-39.1377F, 0.5F, 0.0F, 0.0F, 1.1345F, 0.0F));

    ModelPartData awit = basket.addChild("awit", ModelPartBuilder.create().uv(1, 352).cuboid(4.0F, -33.5F, 37.5313F, 15.0F, 4.0F, 4.0F, new Dilation(0.0F))
        .uv(0, 328).cuboid(14.5F, -33.5F, 37.5313F, 1.0F, 4.0F, 4.0F, new Dilation(0.1F))
        .uv(0, 328).cuboid(7.5F, -33.5F, 37.5313F, 1.0F, 4.0F, 4.0F, new Dilation(0.1F)), ModelTransform.of(-21.0689F, -56.5F, -15.8471F, -0.7854F, 0.0F, 0.0F));

    ModelPartData gascan = basket.addChild("gascan", ModelPartBuilder.create().uv(176, 310).cuboid(9.5F, -36.5F, 37.4063F, 2.0F, 6.0F, 6.0F, new Dilation(0.0F))
        .uv(197, 306).cuboid(10.0F, -38.0F, 37.5313F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-17.0689F, -18.0F, -12.2221F));

    ModelPartData gascan2 = basket.addChild("gascan2", ModelPartBuilder.create().uv(176, 310).cuboid(10.5F, -36.5F, 37.4063F, 2.0F, 6.0F, 6.0F, new Dilation(0.0F))
        .uv(197, 306).cuboid(11.0F, -38.0F, 37.5313F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.9311F, -16.5F, 15.2779F, 0.0F, -1.5708F, 0.0F));

    ModelPartData chainblock123 = basket.addChild("chainblock123", ModelPartBuilder.create(), ModelTransform.pivot(-1.3189F, -60.5237F, 40.0043F));

    ModelPartData chainblock123_r1 = chainblock123.addChild("chainblock123_r1", ModelPartBuilder.create().uv(365, 24).cuboid(22.0F, -16.0F, -35.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F))
        .uv(365, 24).cuboid(22.0F, -16.5F, -32.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-54.0F, 42.6288F, -22.9721F, -1.5708F, 0.0F, 0.0F));

    ModelPartData tophole = turret.addChild("tophole", ModelPartBuilder.create().uv(47, 33).cuboid(-9.0F, -53.5F, 2.0313F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(24, 35).cuboid(1.0F, -53.0F, 2.0313F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(61, 33).cuboid(2.5F, -53.0F, 3.9063F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(84, 32).cuboid(2.5F, -53.0F, 10.1567F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(36, 202).cuboid(-9.0F, -55.0F, 3.9688F, 7.0F, 1.0F, 6.9375F, new Dilation(0.0F))
        .uv(76, 86).cuboid(-8.5F, -54.5F, 2.9688F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(64, 86).cuboid(-8.5F, -54.5F, 11.0319F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(340, 1).cuboid(-9.0F, -53.4688F, 11.9694F, 7.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(11, 51).cuboid(3.0F, -53.0F, 11.907F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 42.0F, 0.0F));

    ModelPartData tophole_r1 = tophole.addChild("tophole_r1", ModelPartBuilder.create().uv(197, 103).cuboid(1.1242F, -55.5313F, -4.2263F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.9575F, 0.0F, 13.9292F, 0.0F, 1.1345F, 0.0F));

    ModelPartData tophole_r2 = tophole.addChild("tophole_r2", ModelPartBuilder.create().uv(173, 202).cuboid(-6.1242F, -55.5313F, -4.2263F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-10.0426F, 0.0F, 13.9292F, 0.0F, -1.1345F, 0.0F));

    ModelPartData tophole_r3 = tophole.addChild("tophole_r3", ModelPartBuilder.create().uv(71, 32).cuboid(-2.3207F, -53.0F, -11.383F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(48, 95).cuboid(-6.5468F, -53.5F, -2.32F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-9.9652F, 0.0F, 13.9604F, 0.0F, -1.1345F, 0.0F));

    ModelPartData tophole_r4 = tophole.addChild("tophole_r4", ModelPartBuilder.create().uv(54, 128).cuboid(2.0305F, -55.5F, 3.6489F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F))
        .uv(147, 175).cuboid(2.0305F, -55.5F, 2.6489F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.9575F, 0.0F, 0.009F, 0.0F, -1.1345F, 0.0F));

    ModelPartData tophole_r5 = tophole.addChild("tophole_r5", ModelPartBuilder.create().uv(159, 175).cuboid(-7.0305F, -55.5F, 3.6489F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F))
        .uv(177, 27).cuboid(-7.0305F, -55.5F, 2.6489F, 5.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-10.0426F, 0.0F, 0.009F, 0.0F, 1.1345F, 0.0F));

    ModelPartData tophole_r6 = tophole.addChild("tophole_r6", ModelPartBuilder.create().uv(0, 91).cuboid(-0.227F, -53.0F, 10.8056F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(52, 141).cuboid(-7.4532F, -53.4688F, 1.7426F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-9.9652F, 0.0F, -0.0222F, 0.0F, 1.1345F, 0.0F));

    ModelPartData tophole_r7 = tophole.addChild("tophole_r7", ModelPartBuilder.create().uv(74, 143).cuboid(4.773F, -53.0F, 6.7431F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(148, 54).cuboid(0.5468F, -53.5F, -2.32F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0348F, 0.0F, 13.9604F, 0.0F, 1.1345F, 0.0F));

    ModelPartData tophole_r8 = tophole.addChild("tophole_r8", ModelPartBuilder.create().uv(86, 88).cuboid(1.6754F, -53.0F, -1.6309F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.4703F, 0.0F, 6.2797F, 0.0F, -1.1345F, 0.0F));

    ModelPartData tophole_r9 = tophole.addChild("tophole_r9", ModelPartBuilder.create().uv(86, 92).cuboid(-1.8718F, -53.0F, 6.5259F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.4703F, 0.0F, 6.2797F, 0.0F, 1.1345F, 0.0F));

    ModelPartData tophole_r10 = tophole.addChild("tophole_r10", ModelPartBuilder.create().uv(86, 90).cuboid(-6.0043F, -53.0F, 0.9479F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.488F, 0.0F, 1.6891F, 0.0F, 1.1345F, 0.0F));

    ModelPartData tophole_r11 = tophole.addChild("tophole_r11", ModelPartBuilder.create().uv(115, 115).cuboid(5.8079F, -53.0F, -7.2089F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.488F, 0.0F, 1.6891F, 0.0F, -1.1345F, 0.0F));

    ModelPartData tophole_r12 = tophole.addChild("tophole_r12", ModelPartBuilder.create().uv(149, 126).cuboid(5.6793F, -53.0F, -7.3205F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(162, 54).cuboid(1.4531F, -53.4688F, 1.7426F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0348F, 0.0F, -0.0222F, 0.0F, -1.1345F, 0.0F));

    ModelPartData turretholder = tophole.addChild("turretholder", ModelPartBuilder.create().uv(169, 290).cuboid(-9.0F, 2.5F, -14.1574F, 18.0F, 8.0F, 1.0F, new Dilation(0.0F))
        .uv(169, 290).cuboid(-9.0F, 2.5F, 10.2192F, 18.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -48.0F, 1.1887F));

    ModelPartData turretholder_r1 = turretholder.addChild("turretholder_r1", ModelPartBuilder.create().uv(1, 315).cuboid(-9.7759F, -65.5F, -7.8189F, 14.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-16.9652F, 68.0F, 10.2727F, 0.0F, -1.1345F, 0.0F));

    ModelPartData turretholder_r2 = turretholder.addChild("turretholder_r2", ModelPartBuilder.create().uv(1, 315).cuboid(-12.4948F, -65.5F, 8.0867F, 14.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-16.9652F, 68.0F, -16.2108F, 0.0F, 1.1345F, 0.0F));

    ModelPartData turretholder_r3 = turretholder.addChild("turretholder_r3", ModelPartBuilder.create().uv(1, 315).cuboid(-1.5052F, -65.5F, 8.0867F, 14.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(16.9652F, 68.0F, -16.2108F, 0.0F, -1.1345F, 0.0F));

    ModelPartData turretholder_r4 = turretholder.addChild("turretholder_r4", ModelPartBuilder.create().uv(1, 315).cuboid(-4.2241F, -65.5F, -7.8189F, 14.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(16.9652F, 68.0F, 10.2727F, 0.0F, 1.1345F, 0.0F));

    ModelPartData gun = turret.addChild("gun", ModelPartBuilder.create().uv(241, 46).cuboid(14.0F, -5.5F, -0.4688F, 9.0F, 8.0F, 10.0F, new Dilation(-0.1F)), ModelTransform.pivot(-18.5F, -5.0F, -20.5F));

    ModelPartData gun_r1 = gun.addChild("gun_r1", ModelPartBuilder.create().uv(67, 43).cuboid(-4.0F, -50.7211F, -29.3194F, 9.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(18.0F, 51.2925F, 14.6674F, -0.2618F, 0.0F, 0.0F));

    ModelPartData gun_r2 = gun.addChild("gun_r2", ModelPartBuilder.create().uv(37, 295).cuboid(-21.7162F, -43.432F, -33.4688F, 2.0F, 2.0F, 8.0F, new Dilation(-0.5F))
        .uv(174, 154).cuboid(-19.0204F, -45.9462F, -28.4688F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 43.0F, 25.0F, 0.0F, 0.0F, 0.7854F));

    ModelPartData barrel = gun.addChild("barrel", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -3.0F));

    ModelPartData barrel_r1 = barrel.addChild("barrel_r1", ModelPartBuilder.create().uv(49, 128).cuboid(-19.0425F, -45.9844F, -44.4688F, 4.0F, 4.0F, 17.0F, new Dilation(-0.5F))
        .uv(115, 31).cuboid(-19.2856F, -46.2414F, -45.9688F, 4.0F, 4.0F, 8.0F, new Dilation(0.0F))
        .uv(179, 145).cuboid(-19.5615F, -46.5035F, -67.9688F, 2.0F, 2.0F, 4.0F, new Dilation(-0.3F))
        .uv(115, 154).cuboid(-19.0425F, -45.9844F, -68.9688F, 4.0F, 4.0F, 24.0F, new Dilation(-0.6F)), ModelTransform.of(0.0F, 44.0F, 28.0F, 0.0F, 0.0F, 0.7854F));

    ModelPartData antenna = turret.addChild("antenna", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 42.0F, -3.0F));

    ModelPartData antenna_r1 = antenna.addChild("antenna_r1", ModelPartBuilder.create().uv(14, 81).cuboid(32.0668F, -56.0F, 12.929F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 86).cuboid(31.5668F, -53.0F, 12.429F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

    ModelPartData bone6 = antenna.addChild("bone6", ModelPartBuilder.create(), ModelTransform.of(0.0F, -1.7188F, -1.6563F, -0.0524F, 0.0F, 0.0F));

    ModelPartData bone7 = bone6.addChild("bone7", ModelPartBuilder.create().uv(0, 101).cuboid(31.2156F, -63.9685F, 12.0778F, 1.0F, 9.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

    ModelPartData bone8 = antenna.addChild("bone8", ModelPartBuilder.create(), ModelTransform.of(0.0F, -12.7188F, -1.6563F, -0.1396F, 0.0F, 0.0F));

    ModelPartData bone9 = bone8.addChild("bone9", ModelPartBuilder.create().uv(76, 65).cuboid(28.29F, -62.963F, 9.1522F, 1.0F, 8.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

    ModelPartData bone10 = antenna.addChild("bone10", ModelPartBuilder.create(), ModelTransform.of(0.0F, -21.7188F, -1.6563F, -0.2793F, 0.0F, 0.0F));

    ModelPartData bone11 = bone10.addChild("bone11", ModelPartBuilder.create().uv(72, 65).cuboid(23.6924F, -64.8456F, 4.5546F, 1.0F, 8.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

    ModelPartData antenna2 = turret.addChild("antenna2", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, 42.0F, -3.0F));

    ModelPartData antenna2_r1 = antenna2.addChild("antenna2_r1", ModelPartBuilder.create().uv(14, 81).cuboid(12.6213F, -56.0F, 32.3744F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 86).cuboid(12.1213F, -53.0F, 31.8744F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

    ModelPartData bone12 = antenna2.addChild("bone12", ModelPartBuilder.create(), ModelTransform.of(0.0F, -1.7188F, -1.6563F, -0.0524F, 0.0F, 0.0F));

    ModelPartData bone13 = bone12.addChild("bone13", ModelPartBuilder.create().uv(0, 101).cuboid(11.7702F, -63.9685F, 31.5232F, 1.0F, 9.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

    ModelPartData bone14 = antenna2.addChild("bone14", ModelPartBuilder.create(), ModelTransform.of(0.0F, -12.7188F, -1.6563F, -0.1396F, 0.0F, 0.0F));

    ModelPartData bone15 = bone14.addChild("bone15", ModelPartBuilder.create().uv(76, 65).cuboid(8.8446F, -62.963F, 28.5977F, 1.0F, 8.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

    ModelPartData bone16 = antenna2.addChild("bone16", ModelPartBuilder.create(), ModelTransform.of(0.0F, -21.7188F, -1.6563F, -0.2793F, 0.0F, 0.0F));

    ModelPartData bone17 = bone16.addChild("bone17", ModelPartBuilder.create().uv(72, 65).cuboid(4.247F, -64.8456F, 24.0F, 1.0F, 8.0F, 1.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

    ModelPartData bone = turret.addChild("bone", ModelPartBuilder.create(), ModelTransform.of(0.0F, 44.1006F, -8.044F, 0.0F, -0.5236F, 0.0F));

    ModelPartData bone_r1 = bone.addChild("bone_r1", ModelPartBuilder.create().uv(11, 291).cuboid(-3.2048F, -49.2428F, -26.6428F, 14.9375F, 9.0F, 0.0F, new Dilation(0.0F))
        .uv(356, 94).cuboid(11.7327F, -49.2428F, -26.5803F, 3.0F, 9.0F, 0.0F, new Dilation(0.0F))
        .uv(169, 247).cuboid(-3.2048F, -49.2428F, -26.5803F, 14.9375F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, -0.0873F, 0.0F));

    ModelPartData bone3 = bone.addChild("bone3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

    ModelPartData bone5 = turret.addChild("bone5", ModelPartBuilder.create(), ModelTransform.of(0.0F, 44.1006F, -8.044F, 0.0F, 0.5236F, 0.0F));

    ModelPartData bone5_r1 = bone5.addChild("bone5_r1", ModelPartBuilder.create().uv(11, 291).mirrored().cuboid(-11.7327F, -49.2428F, -26.6428F, 14.9375F, 9.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
        .uv(356, 94).mirrored().cuboid(-14.7327F, -49.2428F, -26.5803F, 3.0F, 9.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
        .uv(169, 247).mirrored().cuboid(-11.7327F, -49.2428F, -26.5803F, 14.9375F, 9.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, 0.0873F, 0.0F));

    ModelPartData bone18 = bone5.addChild("bone18", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

    ModelPartData bone2 = turret.addChild("bone2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 44.1006F, -8.044F, 0.0F, 0.5236F, 0.0F));

    ModelPartData wheel10 = turret.addChild("wheel10", ModelPartBuilder.create(), ModelTransform.pivot(21.75F, -8.5867F, 32.8893F));

    ModelPartData whi11 = wheel10.addChild("whi11", ModelPartBuilder.create().uv(184, 259).cuboid(14.2188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(37, 259).cuboid(14.2188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(280, 254).cuboid(14.2188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 250).cuboid(14.2188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(247, 180).cuboid(14.4688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F))
        .uv(280, 246).cuboid(15.2188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-21.0F, 1.0313F, 2.5F, -0.3927F, 0.0F, 0.0F));

    ModelPartData whi11_r1 = whi11.addChild("whi11_r1", ModelPartBuilder.create().uv(247, 162).cuboid(14.4688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.2699F, 19.2857F, -1.5708F, 0.0F, 0.0F));

    ModelPartData whi11_r2 = whi11.addChild("whi11_r2", ModelPartBuilder.create().uv(0, 281).cuboid(14.2188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.7006F, 27.1098F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi11_r3 = whi11.addChild("whi11_r3", ModelPartBuilder.create().uv(16, 281).cuboid(14.2188F, 18.8241F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.153F, 23.2562F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi11_r4 = whi11.addChild("whi11_r4", ModelPartBuilder.create().uv(32, 281).cuboid(14.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.8956F, 22.7623F, 0.7854F, 0.0F, 0.0F));

    ModelPartData whi11_r5 = whi11.addChild("whi11_r5", ModelPartBuilder.create().uv(48, 281).cuboid(14.2188F, -14.1759F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.6279F, 17.4946F, 0.7854F, 0.0F, 0.0F));

    ModelPartData part3 = body_main.addChild("part3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData base = body_main.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData part2 = base.addChild("part2", ModelPartBuilder.create().uv(0, 101).mirrored().cuboid(-23.0F, -18.0F, -41.0F, 9.0F, 4.0F, 97.0F, new Dilation(0.0F)).mirrored(false)
        .uv(312, 3).mirrored().cuboid(-23.0F, -18.1563F, -32.0F, 9.0F, 1.0F, 1.0F, new Dilation(-0.1F)).mirrored(false)
        .uv(115, 12).mirrored().cuboid(-23.0F, -14.0F, -40.0F, 0.1875F, 5.0F, 80.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 352).mirrored().cuboid(-23.0625F, -18.0F, -21.0F, 0.0F, 9.0F, 61.0F, new Dilation(0.0F)).mirrored(false)
        .uv(1, 306).mirrored().cuboid(-23.125F, -18.0F, -19.0F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(1, 306).mirrored().cuboid(-23.125F, -18.0F, -2.0F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(1, 306).mirrored().cuboid(-23.125F, -18.0F, 3.0F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(1, 306).mirrored().cuboid(-23.125F, -18.0F, 22.0F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(1, 306).mirrored().cuboid(-23.125F, -18.0F, 12.5F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(1, 306).mirrored().cuboid(-23.125F, -18.0F, 39.0F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(35, 149).mirrored().cuboid(-22.0F, -22.0F, 33.0F, 8.0F, 4.0F, 23.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 202).mirrored().cuboid(-22.0F, -20.0F, 1.0F, 8.0F, 2.0F, 20.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData part2_r1 = part2.addChild("part2_r1", ModelPartBuilder.create().uv(0, 74).mirrored().cuboid(-70.9688F, -23.7321F, -57.06F, 0.0625F, 4.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(48.0F, 13.2111F, -9.7531F, -2.2864F, 0.0F, 0.0F));

    ModelPartData part2_r2 = part2.addChild("part2_r2", ModelPartBuilder.create().uv(115, 10).mirrored().cuboid(-70.9375F, -27.4111F, -27.0113F, 0.0F, 4.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(48.0F, 21.7248F, -45.195F, -0.8901F, 0.0F, 0.0F));

    ModelPartData part2_r3 = part2.addChild("part2_r3", ModelPartBuilder.create().uv(241, 23).mirrored().cuboid(-69.9688F, -23.9848F, 20.3486F, 8.0F, 4.0F, 13.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(48.0F, 6.9064F, 3.814F, 0.1571F, 0.0F, 0.0F));

    ModelPartData part2_r4 = part2.addChild("part2_r4", ModelPartBuilder.create().uv(0, 159).mirrored().cuboid(-22.0F, -20.0F, 17.0F, 8.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 8.9914F, 0.2929F, 0.7854F, 0.0F, 0.0F));

    ModelPartData part1 = base.addChild("part1", ModelPartBuilder.create().uv(0, 101).cuboid(14.0F, -18.0F, -41.0F, 9.0F, 4.0F, 97.0F, new Dilation(0.0F))
        .uv(312, 3).cuboid(14.0F, -18.1563F, -32.0F, 9.0F, 1.0F, 1.0F, new Dilation(-0.1F))
        .uv(115, 12).cuboid(22.8125F, -14.0F, -40.0F, 0.1875F, 5.0F, 80.0F, new Dilation(0.0F))
        .uv(304, 0).cuboid(23.0625F, -17.5F, -32.0F, 0.0F, 9.0F, 11.0F, new Dilation(0.0F))
        .uv(373, 20).cuboid(22.0F, -17.5F, 22.0F, 0.0F, 9.0F, 18.0F, new Dilation(0.0F))
        .uv(0, 352).cuboid(23.0625F, -18.0F, -21.0F, 0.0F, 9.0F, 61.0F, new Dilation(0.0F))
        .uv(1, 306).cuboid(23.125F, -18.0F, -19.0F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F))
        .uv(1, 306).cuboid(23.125F, -18.0F, -2.0F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F))
        .uv(1, 306).cuboid(23.125F, -18.0F, 3.0F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F))
        .uv(1, 306).cuboid(23.125F, -18.0F, 22.0F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F))
        .uv(1, 306).cuboid(23.125F, -18.0F, 12.5F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F))
        .uv(1, 306).cuboid(23.125F, -18.0F, 39.0F, 0.0F, 9.0F, 1.0F, new Dilation(0.0F))
        .uv(35, 149).cuboid(14.0F, -22.0F, 33.0F, 8.0F, 4.0F, 23.0F, new Dilation(0.0F))
        .uv(0, 202).cuboid(14.5F, -20.0F, 1.0F, 8.0F, 2.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData part1_r1 = part1.addChild("part1_r1", ModelPartBuilder.create().uv(0, 74).cuboid(70.9063F, -23.7321F, -57.06F, 0.0625F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-48.0F, 13.2111F, -9.7531F, -2.2864F, 0.0F, 0.0F));

    ModelPartData part1_r2 = part1.addChild("part1_r2", ModelPartBuilder.create().uv(115, 10).cuboid(70.9375F, -27.4111F, -27.0113F, 0.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-48.0F, 21.7248F, -45.195F, -0.8901F, 0.0F, 0.0F));

    ModelPartData part1_r3 = part1.addChild("part1_r3", ModelPartBuilder.create().uv(143, 192).mirrored().cuboid(-70.9375F, -30.0857F, -35.1712F, 9.0F, 1.0F, 5.0F, new Dilation(0.0F)).mirrored(false)
        .uv(143, 192).cuboid(-34.0625F, -30.0857F, -35.1712F, 9.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(48.0F, -18.0605F, 1.6081F, 0.7854F, 0.0F, 0.0F));

    ModelPartData part1_r4 = part1.addChild("part1_r4", ModelPartBuilder.create().uv(241, 23).cuboid(61.9688F, -23.9848F, 20.3486F, 8.0F, 4.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(-48.0F, 6.9064F, 3.814F, 0.1571F, 0.0F, 0.0F));

    ModelPartData part1_r5 = part1.addChild("part1_r5", ModelPartBuilder.create().uv(0, 159).cuboid(14.0F, -20.0F, 17.0F, 8.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.9914F, 0.2929F, 0.7854F, 0.0F, 0.0F));

    ModelPartData part1_r6 = part1.addChild("part1_r6", ModelPartBuilder.create().uv(11, 43).cuboid(0.519F, -30.9602F, 24.0F, 2.0F, 2.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.of(-0.2591F, 0.6967F, -11.0F, 0.0F, 0.0F, 0.7854F));

    ModelPartData part1_r7 = part1.addChild("part1_r7", ModelPartBuilder.create().uv(304, 0).cuboid(23.0625F, -17.5F, 21.0F, 0.0F, 9.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

    ModelPartData hooksback = part1.addChild("hooksback", ModelPartBuilder.create().uv(341, 94).cuboid(14.125F, -22.0F, 48.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F))
        .uv(341, 94).mirrored().cuboid(-14.125F, -22.0F, 48.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 8.0F));

    ModelPartData rearlight1 = part1.addChild("rearlight1", ModelPartBuilder.create().uv(35, 149).cuboid(18.5F, -21.5F, 55.2813F, 3.0F, 3.0F, 3.0F, new Dilation(-0.1F)), ModelTransform.pivot(0.5F, -0.5F, 0.0F));

    ModelPartData rearlights = rearlight1.addChild("rearlights", ModelPartBuilder.create().uv(338, 15).mirrored().cuboid(-21.5F, -21.5F, 47.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
        .uv(338, 15).cuboid(19.5F, -21.5F, 47.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 0.5F, 8.0F));

    ModelPartData rearlight2 = part1.addChild("rearlight2", ModelPartBuilder.create().uv(35, 149).mirrored().cuboid(-21.5F, -21.5F, 55.2813F, 3.0F, 3.0F, 3.0F, new Dilation(-0.1F)).mirrored(false), ModelTransform.pivot(-0.5F, -0.5F, 0.0F));

    ModelPartData mid = base.addChild("mid", ModelPartBuilder.create().uv(0, 202).cuboid(-61.5F, -14.1882F, -87.9705F, 27.0F, 1.0F, 66.0F, new Dilation(0.0F))
        .uv(305, 151).cuboid(-61.5F, -13.1317F, -84.7362F, 5.0F, 1.0F, 60.5F, new Dilation(0.0F))
        .uv(305, 151).mirrored().cuboid(-39.5F, -13.1317F, -84.7362F, 5.0F, 1.0F, 60.5F, new Dilation(0.0F)).mirrored(false)
        .uv(115, 101).cuboid(-62.0F, -28.2266F, -7.7501F, 28.0F, 6.0F, 3.0F, new Dilation(0.0F))
        .uv(481, 17).cuboid(-48.0F, -27.7266F, -4.7189F, 13.0F, 6.0F, 0.0F, new Dilation(0.0F))
        .uv(481, 17).cuboid(-61.5F, -27.7266F, -4.7189F, 13.0F, 6.0F, 0.0F, new Dilation(0.0F))
        .uv(330, 275).cuboid(-62.0F, -31.2266F, -29.7501F, 28.0F, 1.0F, 22.0F, new Dilation(0.0F))
        .uv(172, 39).cuboid(-43.0F, -31.3204F, -15.7501F, 8.0F, 1.0F, 6.0F, new Dilation(0.0F))
        .uv(67, 57).cuboid(-61.0F, -31.3204F, -15.7501F, 8.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(48.0F, 9.2266F, 62.7501F));

    ModelPartData mid_r1 = mid.addChild("mid_r1", ModelPartBuilder.create().uv(115, 80).cuboid(-62.0F, -28.1882F, -6.382F, 28.0F, 2.0F, 4.1563F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.7818F, -23.1694F, -0.7854F, 0.0F, 0.0F));

    ModelPartData mid_r2 = mid.addChild("mid_r2", ModelPartBuilder.create().uv(0, 67).cuboid(-61.5F, -25.1882F, -24.382F, 27.0F, 1.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.1817F, 11.6518F, 0.576F, 0.0F, 0.0F));

    ModelPartData mid_r3 = mid.addChild("mid_r3", ModelPartBuilder.create().uv(80, 40).mirrored().cuboid(8.5F, 17.3131F, 65.6408F, 5.0F, 1.0F, 2.5F, new Dilation(0.0F)).mirrored(false)
        .uv(80, 40).cuboid(-13.5F, 17.3131F, 65.6408F, 5.0F, 1.0F, 2.5F, new Dilation(0.0F)), ModelTransform.of(-48.0F, -0.988F, -91.4664F, 0.4363F, 0.0F, 0.0F));

    ModelPartData mid_r4 = mid.addChild("mid_r4", ModelPartBuilder.create().uv(64, 93).mirrored().cuboid(57.5F, -27.2649F, -21.6603F, 4.0F, 1.0F, 1.0F, new Dilation(0.2F)).mirrored(false)
        .uv(64, 93).cuboid(34.5F, -27.2649F, -21.6603F, 4.0F, 1.0F, 1.0F, new Dilation(0.2F))
        .uv(297, 52).cuboid(34.0F, -28.1287F, -27.24F, 28.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(115, 115).cuboid(34.0F, -28.1882F, -97.1633F, 28.0F, 1.0F, 76.7813F, new Dilation(0.0F)), ModelTransform.of(-96.0F, -50.9546F, -128.6394F, -3.0648F, 0.0F, 0.0F));

    ModelPartData mid_r5 = mid.addChild("mid_r5", ModelPartBuilder.create().uv(299, 43).mirrored().cuboid(60.5F, -27.2649F, -21.6603F, 1.0F, 1.0F, 1.0F, new Dilation(0.3F)).mirrored(false)
        .uv(299, 43).cuboid(35.5F, -27.2649F, -21.6603F, 1.0F, 1.0F, 1.0F, new Dilation(0.3F)), ModelTransform.of(-96.5F, -52.5796F, -124.8894F, 3.1311F, 0.0F, 0.0F));

    ModelPartData mid_r6 = mid.addChild("mid_r6", ModelPartBuilder.create().uv(33, 145).mirrored().cuboid(-39.5F, -25.1882F, -9.382F, 5.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(33, 145).cuboid(-61.5F, -25.1882F, -9.382F, 5.0F, 1.0F, 3.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.6096F, -87.4818F, -0.3491F, 0.0F, 0.0F));

    ModelPartData mid_r7 = mid.addChild("mid_r7", ModelPartBuilder.create().uv(115, 0).cuboid(-62.0F, -25.1882F, -24.382F, 28.0F, 1.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.7556F, -87.8799F, -0.3665F, 0.0F, 0.0F));

    ModelPartData mid_r8 = mid.addChild("mid_r8", ModelPartBuilder.create().uv(0, 86).cuboid(-62.0F, -25.1882F, -28.382F, 28.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.4982F, -107.9451F, -0.8901F, 0.0F, 0.0F));

    ModelPartData bone4 = mid.addChild("bone4", ModelPartBuilder.create(), ModelTransform.of(-96.0F, -50.9546F, -128.6394F, -0.7854F, 0.0F, 0.0F));

    ModelPartData bone4_r1 = bone4.addChild("bone4_r1", ModelPartBuilder.create().uv(330, 46).cuboid(-60.5F, 18.9851F, 126.3397F, 2.0F, 1.0F, 1.0F, new Dilation(-0.2F)), ModelTransform.of(-87.3397F, -91.2669F, 42.0877F, 0.0F, 1.5708F, 0.0F));

    ModelPartData bone4_r2 = bone4.addChild("bone4_r2", ModelPartBuilder.create().uv(330, 46).mirrored().cuboid(58.5F, 18.9851F, 126.3397F, 2.0F, 1.0F, 1.0F, new Dilation(-0.2F)).mirrored(false), ModelTransform.of(183.3397F, -91.2669F, 42.0877F, 0.0F, -1.5708F, 0.0F));

    ModelPartData driverwindow = mid.addChild("driverwindow", ModelPartBuilder.create().uv(11, 48).cuboid(-2.0F, 14.3746F, 46.3919F, 4.0F, 2.0F, 1.7813F, new Dilation(0.0F)), ModelTransform.of(-48.0F, -50.9546F, -128.6394F, -0.1745F, 0.0F, 0.0F));

    ModelPartData driverwindow_r1 = driverwindow.addChild("driverwindow_r1", ModelPartBuilder.create().uv(64, 87).cuboid(-5.414F, 14.4018F, 45.9931F, 3.0F, 2.0F, 1.7813F, new Dilation(0.0F)), ModelTransform.of(-22.9059F, 0.0F, 5.1998F, 0.0F, 0.5236F, 0.0F));

    ModelPartData driverwindow_r2 = driverwindow.addChild("driverwindow_r2", ModelPartBuilder.create().uv(89, 57).cuboid(2.414F, 14.4018F, 45.9931F, 3.0F, 2.0F, 1.7813F, new Dilation(0.0F)), ModelTransform.of(22.9059F, 0.0F, 5.1998F, 0.0F, -0.5236F, 0.0F));

    ModelPartData playercabin = mid.addChild("playercabin", ModelPartBuilder.create(), ModelTransform.pivot(-50.0F, -26.2266F, -59.7501F));

    ModelPartData crosshair = playercabin.addChild("crosshair", ModelPartBuilder.create().uv(366, 246).mirrored().cuboid(-2.9063F, -1.9616F, -20.5165F, 5.0F, 5.0F, 0.0F, new Dilation(-0.2F)).mirrored(false), ModelTransform.pivot(2.1654F, -8.0F, 5.4476F));

    ModelPartData playercabin2 = playercabin.addChild("playercabin2", ModelPartBuilder.create().uv(85, 306).cuboid(-4.0F, -28.0F, -9.5F, 8.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 17.0F, 5.0F));

    ModelPartData side_cover = mid.addChild("side_cover", ModelPartBuilder.create().uv(294, 0).cuboid(-35.5F, -15.0065F, -99.6223F, 1.0F, 7.0F, 66.0F, new Dilation(0.0F))
        .uv(166, 202).cuboid(-35.0F, -24.0449F, -41.4019F, 1.0F, 7.0F, 22.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.1817F, 11.6518F));

    ModelPartData side_cover_r1 = side_cover.addChild("side_cover_r1", ModelPartBuilder.create().uv(153, 164).cuboid(-35.5F, -32.1882F, -24.382F, 1.0F, 7.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.576F, 0.0F, 0.0F));

    ModelPartData side_cover_r2 = side_cover.addChild("side_cover_r2", ModelPartBuilder.create().uv(228, 192).cuboid(-35.0F, -30.1882F, -97.1633F, 1.0F, 2.0F, 75.7813F, new Dilation(0.0F))
        .uv(0, 269).cuboid(-35.0F, -32.1882F, -96.6633F, 1.0F, 2.0F, 72.7813F, new Dilation(0.0F))
        .uv(333, 333).cuboid(-35.0F, -34.1882F, -96.6633F, 1.0F, 2.0F, 61.7813F, new Dilation(0.0F)), ModelTransform.of(0.0F, -44.7729F, -140.2912F, -3.0648F, 0.0F, 0.0F));

    ModelPartData side_cover_r3 = side_cover.addChild("side_cover_r3", ModelPartBuilder.create().uv(152, 247).cuboid(-35.0F, -29.1882F, -24.382F, 1.0F, 4.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 18.9373F, -99.5317F, -0.3665F, 0.0F, 0.0F));

    ModelPartData side_cover2 = mid.addChild("side_cover2", ModelPartBuilder.create().uv(160, 279).cuboid(34.5F, -15.0065F, -99.6223F, 1.0F, 7.0F, 66.0F, new Dilation(0.0F))
        .uv(120, 202).cuboid(34.0F, -24.0449F, -41.4019F, 1.0F, 7.0F, 22.0F, new Dilation(0.0F)), ModelTransform.pivot(-96.0F, -6.1817F, 11.6518F));

    ModelPartData side_cover2_r1 = side_cover2.addChild("side_cover2_r1", ModelPartBuilder.create().uv(149, 110).cuboid(34.5F, -32.1882F, -24.382F, 1.0F, 7.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.576F, 0.0F, 0.0F));

    ModelPartData side_cover2_r2 = side_cover2.addChild("side_cover2_r2", ModelPartBuilder.create().uv(217, 0).cuboid(34.0F, -30.1882F, -97.1633F, 1.0F, 2.0F, 75.7813F, new Dilation(0.0F))
        .uv(247, 77).cuboid(34.0F, -32.1882F, -96.6633F, 1.0F, 2.0F, 72.7813F, new Dilation(0.0F))
        .uv(330, 212).cuboid(34.0F, -34.1882F, -96.6633F, 1.0F, 2.0F, 61.7813F, new Dilation(0.0F)), ModelTransform.of(0.0F, -44.7729F, -140.2912F, -3.0648F, 0.0F, 0.0F));

    ModelPartData side_cover2_r3 = side_cover2.addChild("side_cover2_r3", ModelPartBuilder.create().uv(120, 245).cuboid(34.0F, -29.1882F, -24.382F, 1.0F, 4.0F, 15.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 18.9373F, -99.5317F, -0.3665F, 0.0F, 0.0F));

    ModelPartData chainright = ulra_super.addChild("chainright", ModelPartBuilder.create(), ModelTransform.pivot(-25.75F, 18.0F, -2.0F));

    ModelPartData chaineiei = chainright.addChild("chaineiei", ModelPartBuilder.create(), ModelTransform.pivot(26.0F, 8.3582F, 4.4907F));

    ModelPartData chainrailright2 = chaineiei.addChild("chainrailright2", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, -8.9132F, -40.1705F));

    ModelPartData chainblock30 = chainrailright2.addChild("chainblock30", ModelPartBuilder.create(), ModelTransform.pivot(26.0F, 0.0313F, 0.0313F));

    ModelPartData chainblock30_r1 = chainblock30.addChild("chainblock30_r1", ModelPartBuilder.create().uv(393, 23).cuboid(22.0F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 27.2878F, 18.1867F, -0.6109F, 0.0F, 0.0F));

    ModelPartData chainblock31 = chainrailright2.addChild("chainblock31", ModelPartBuilder.create(), ModelTransform.pivot(26.0F, 0.0313F, 3.0313F));

    ModelPartData chainblock31_r1 = chainblock31.addChild("chainblock31_r1", ModelPartBuilder.create().uv(393, 23).cuboid(22.0F, -16.0F, -26.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 21.0576F, 27.3009F, -0.2618F, 0.0F, 0.0F));

    ModelPartData chainblock31_r2 = chainblock31.addChild("chainblock31_r2", ModelPartBuilder.create().uv(393, 23).cuboid(22.0F, -16.0F, -29.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F))
        .uv(393, 23).cuboid(22.0F, -16.0F, -32.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F))
        .uv(393, 23).cuboid(22.0F, -16.0F, -35.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F))
        .uv(393, 23).cuboid(22.0F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 24.504F, 23.2641F, -0.4363F, 0.0F, 0.0F));

    ModelPartData chainblock32 = chainrailright2.addChild("chainblock32", ModelPartBuilder.create(), ModelTransform.pivot(26.0F, 0.0313F, 6.0313F));

    ModelPartData chainblock33 = chainrailright2.addChild("chainblock33", ModelPartBuilder.create(), ModelTransform.pivot(26.0F, 0.0313F, 9.0313F));

    ModelPartData chainblock34 = chainrailright2.addChild("chainblock34", ModelPartBuilder.create(), ModelTransform.pivot(26.0F, 0.0313F, 12.0313F));

    ModelPartData chainblock35 = chainrailright2.addChild("chainblock35", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.5161F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 15.0313F));

    ModelPartData chainblock36 = chainrailright2.addChild("chainblock36", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 18.0313F));

    ModelPartData chainblock37 = chainrailright2.addChild("chainblock37", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 21.0313F));

    ModelPartData chainblock38 = chainrailright2.addChild("chainblock38", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 24.0313F));

    ModelPartData chainblock39 = chainrailright2.addChild("chainblock39", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 27.0313F));

    ModelPartData chainblock40 = chainrailright2.addChild("chainblock40", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 30.0313F));

    ModelPartData chainblock41 = chainrailright2.addChild("chainblock41", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 33.0313F));

    ModelPartData chainblock42 = chainrailright2.addChild("chainblock42", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 36.0313F));

    ModelPartData chainblock43 = chainrailright2.addChild("chainblock43", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 39.0313F));

    ModelPartData chainblock44 = chainrailright2.addChild("chainblock44", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 42.0313F));

    ModelPartData chainblock45 = chainrailright2.addChild("chainblock45", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 45.0313F));

    ModelPartData chainblock46 = chainrailright2.addChild("chainblock46", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.5161F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 48.0313F));

    ModelPartData chainblock47 = chainrailright2.addChild("chainblock47", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.5161F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 51.0313F));

    ModelPartData chainblock48 = chainrailright2.addChild("chainblock48", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 54.0313F));

    ModelPartData chainblock49 = chainrailright2.addChild("chainblock49", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 57.0313F));

    ModelPartData chainblock50 = chainrailright2.addChild("chainblock50", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 60.0313F));

    ModelPartData chainblock51 = chainrailright2.addChild("chainblock51", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 63.0313F));

    ModelPartData chainblock52 = chainrailright2.addChild("chainblock52", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 66.0313F));

    ModelPartData chainblock53 = chainrailright2.addChild("chainblock53", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 69.0313F));

    ModelPartData chainblock54 = chainrailright2.addChild("chainblock54", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(26.0F, 0.0313F, 72.0313F));

    ModelPartData chainblock55 = chainrailright2.addChild("chainblock55", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5859F, -3.5451F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, -0.1875F, 75.0313F, 0.0873F, 0.0F, 0.0F));

    ModelPartData chainblock56 = chainrailright2.addChild("chainblock56", ModelPartBuilder.create(), ModelTransform.pivot(26.0F, 0.0313F, 78.0313F));

    ModelPartData chainblock56_r1 = chainblock56.addChild("chainblock56_r1", ModelPartBuilder.create().uv(393, 23).cuboid(21.9375F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, -2.4512F, 37.7047F, 0.4363F, 0.0F, 0.0F));

    ModelPartData chainblock57 = chainrailright2.addChild("chainblock57", ModelPartBuilder.create(), ModelTransform.pivot(26.0F, 0.0313F, 81.0313F));

    ModelPartData chainblock57_r1 = chainblock57.addChild("chainblock57_r1", ModelPartBuilder.create().uv(393, 23).cuboid(22.0F, -16.0F, -35.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, -12.3712F, 33.0279F, 0.6981F, 0.0F, 0.0F));

    ModelPartData chainblock58 = chainrailright2.addChild("chainblock58", ModelPartBuilder.create(), ModelTransform.pivot(26.0F, 0.0313F, 84.0313F));

    ModelPartData chainblock58_r1 = chainblock58.addChild("chainblock58_r1", ModelPartBuilder.create().uv(393, 23).cuboid(22.125F, -16.0F, -32.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, -18.6566F, 32.7529F, 0.7854F, 0.0F, 0.0F));

    ModelPartData chainblock58_r2 = chainblock58.addChild("chainblock58_r2", ModelPartBuilder.create().uv(433, 32).cuboid(22.0938F, -16.5625F, -29.1875F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, -12.3712F, 30.0279F, 0.7156F, 0.0F, 0.0F));

    ModelPartData chainblock58_r3 = chainblock58.addChild("chainblock58_r3", ModelPartBuilder.create().uv(393, 23).cuboid(22.0F, -16.0F, -32.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, -12.3712F, 30.0279F, 0.6981F, 0.0F, 0.0F));

    ModelPartData chainrailleft3 = chaineiei.addChild("chainrailleft3", ModelPartBuilder.create(), ModelTransform.pivot(7.5F, -8.9132F, -40.1705F));

    ModelPartData chainblock62 = chainrailleft3.addChild("chainblock62", ModelPartBuilder.create(), ModelTransform.pivot(-26.0F, 0.0313F, 0.0313F));

    ModelPartData chainblock62_r1 = chainblock62.addChild("chainblock62_r1", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-30.0F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, 27.2878F, 18.1867F, -0.6109F, 0.0F, 0.0F));

    ModelPartData chainblock63 = chainrailleft3.addChild("chainblock63", ModelPartBuilder.create(), ModelTransform.pivot(-26.0F, 0.0313F, 3.0313F));

    ModelPartData chainblock63_r1 = chainblock63.addChild("chainblock63_r1", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-30.0F, -16.0F, -26.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, 21.0576F, 27.3009F, -0.2618F, 0.0F, 0.0F));

    ModelPartData chainblock63_r2 = chainblock63.addChild("chainblock63_r2", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-30.0F, -16.0F, -29.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
        .uv(393, 23).mirrored().cuboid(-30.0F, -16.0F, -32.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
        .uv(393, 23).mirrored().cuboid(-30.0F, -16.0F, -35.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
        .uv(393, 23).mirrored().cuboid(-30.0F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, 24.504F, 23.2641F, -0.4363F, 0.0F, 0.0F));

    ModelPartData chainblock64 = chainrailleft3.addChild("chainblock64", ModelPartBuilder.create(), ModelTransform.pivot(-26.0F, 0.0313F, 6.0313F));

    ModelPartData chainblock65 = chainrailleft3.addChild("chainblock65", ModelPartBuilder.create(), ModelTransform.pivot(-26.0F, 0.0313F, 9.0313F));

    ModelPartData chainblock66 = chainrailleft3.addChild("chainblock66", ModelPartBuilder.create(), ModelTransform.pivot(-26.0F, 0.0313F, 12.0313F));

    ModelPartData chainblock67 = chainrailleft3.addChild("chainblock67", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.5161F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 15.0313F));

    ModelPartData chainblock68 = chainrailleft3.addChild("chainblock68", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 18.0313F));

    ModelPartData chainblock69 = chainrailleft3.addChild("chainblock69", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 21.0313F));

    ModelPartData chainblock70 = chainrailleft3.addChild("chainblock70", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 24.0313F));

    ModelPartData chainblock71 = chainrailleft3.addChild("chainblock71", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 27.0313F));

    ModelPartData chainblock72 = chainrailleft3.addChild("chainblock72", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 30.0313F));

    ModelPartData chainblock73 = chainrailleft3.addChild("chainblock73", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 33.0313F));

    ModelPartData chainblock74 = chainrailleft3.addChild("chainblock74", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 36.0313F));

    ModelPartData chainblock75 = chainrailleft3.addChild("chainblock75", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 39.0313F));

    ModelPartData chainblock76 = chainrailleft3.addChild("chainblock76", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 42.0313F));

    ModelPartData chainblock77 = chainrailleft3.addChild("chainblock77", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 45.0313F));

    ModelPartData chainblock78 = chainrailleft3.addChild("chainblock78", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.5161F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 48.0313F));

    ModelPartData chainblock79 = chainrailleft3.addChild("chainblock79", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.5161F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 51.0313F));

    ModelPartData chainblock80 = chainrailleft3.addChild("chainblock80", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 54.0313F));

    ModelPartData chainblock81 = chainrailleft3.addChild("chainblock81", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 57.0313F));

    ModelPartData chainblock82 = chainrailleft3.addChild("chainblock82", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 60.0313F));

    ModelPartData chainblock83 = chainrailleft3.addChild("chainblock83", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 63.0313F));

    ModelPartData chainblock84 = chainrailleft3.addChild("chainblock84", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 66.0313F));

    ModelPartData chainblock85 = chainrailleft3.addChild("chainblock85", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 69.0313F));

    ModelPartData chainblock86 = chainrailleft3.addChild("chainblock86", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5136F, -3.516F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-26.0F, 0.0313F, 72.0313F));

    ModelPartData chainblock87 = chainrailleft3.addChild("chainblock87", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.8359F, -3.5451F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 75.0313F, 0.0873F, 0.0F, 0.0F));

    ModelPartData chainblock88 = chainrailleft3.addChild("chainblock88", ModelPartBuilder.create(), ModelTransform.pivot(-26.0F, 0.0313F, 78.0313F));

    ModelPartData chainblock88_r1 = chainblock88.addChild("chainblock88_r1", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-29.9375F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, -2.4512F, 37.7047F, 0.4363F, 0.0F, 0.0F));

    ModelPartData chainblock89 = chainrailleft3.addChild("chainblock89", ModelPartBuilder.create(), ModelTransform.pivot(-26.0F, 0.0313F, 81.0313F));

    ModelPartData chainblock89_r1 = chainblock89.addChild("chainblock89_r1", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-30.0F, -16.0F, -35.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, -12.3712F, 33.0279F, 0.6981F, 0.0F, 0.0F));

    ModelPartData chainblock90 = chainrailleft3.addChild("chainblock90", ModelPartBuilder.create(), ModelTransform.pivot(-26.0F, 0.0313F, 84.0313F));

    ModelPartData chainblock90_r1 = chainblock90.addChild("chainblock90_r1", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-30.125F, -16.0F, -32.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, -18.6566F, 32.7529F, 0.7854F, 0.0F, 0.0F));

    ModelPartData chainblock90_r2 = chainblock90.addChild("chainblock90_r2", ModelPartBuilder.create().uv(433, 32).mirrored().cuboid(-30.0625F, -16.5625F, -29.1875F, 8.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, -12.3712F, 30.0279F, 0.7156F, 0.0F, 0.0F));

    ModelPartData chainblock90_r3 = chainblock90.addChild("chainblock90_r3", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-30.0F, -16.0F, -32.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, -12.3712F, 30.0279F, 0.6981F, 0.0F, 0.0F));

    ModelPartData wheelssss = chaineiei.addChild("wheelssss", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -8.118F, 48.7018F));

    ModelPartData wheel1 = wheelssss.addChild("wheel1", ModelPartBuilder.create(), ModelTransform.pivot(21.0F, -5.3269F, -77.8032F));

    ModelPartData whi2 = wheel1.addChild("whi2", ModelPartBuilder.create().uv(184, 259).cuboid(14.2188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(184, 259).mirrored().cuboid(-21.7188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(37, 259).cuboid(14.2188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(37, 259).mirrored().cuboid(-21.7188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 254).cuboid(14.2188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 254).mirrored().cuboid(-21.7188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 250).cuboid(14.2188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 250).mirrored().cuboid(-21.7188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 180).cuboid(14.4688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F))
        .uv(247, 180).mirrored().cuboid(-20.9688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 246).cuboid(15.2188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
        .uv(280, 246).mirrored().cuboid(-21.7188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-21.0F, 0.5313F, 2.5F, -0.3927F, 0.0F, 0.0F));

    ModelPartData whi2_r1 = whi2.addChild("whi2_r1", ModelPartBuilder.create().uv(247, 162).mirrored().cuboid(-20.4688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 162).cuboid(14.9688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 6.2698F, 19.2857F, -1.5708F, 0.0F, 0.0F));

    ModelPartData whi2_r2 = whi2.addChild("whi2_r2", ModelPartBuilder.create().uv(0, 281).mirrored().cuboid(-21.2188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 281).cuboid(14.7188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.7006F, 27.1098F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi2_r3 = whi2.addChild("whi2_r3", ModelPartBuilder.create().uv(16, 281).mirrored().cuboid(-21.2188F, 18.8241F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(16, 281).cuboid(14.7188F, 18.8241F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.153F, 23.2562F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi2_r4 = whi2.addChild("whi2_r4", ModelPartBuilder.create().uv(32, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(32, 281).cuboid(14.7188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -7.8956F, 22.7623F, 0.7854F, 0.0F, 0.0F));

    ModelPartData whi2_r5 = whi2.addChild("whi2_r5", ModelPartBuilder.create().uv(48, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(48, 281).cuboid(14.7188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.6279F, 17.4946F, 0.7854F, 0.0F, 0.0F));

    ModelPartData wheel2 = wheelssss.addChild("wheel2", ModelPartBuilder.create(), ModelTransform.pivot(21.0F, -5.8269F, -14.8032F));

    ModelPartData whi3 = wheel2.addChild("whi3", ModelPartBuilder.create().uv(184, 259).cuboid(14.2188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(184, 259).mirrored().cuboid(-21.7188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(37, 259).cuboid(14.2188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(37, 259).mirrored().cuboid(-21.7188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 254).cuboid(14.2188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 254).mirrored().cuboid(-21.7188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 250).cuboid(14.2188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 250).mirrored().cuboid(-21.7188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 180).cuboid(14.4688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F))
        .uv(247, 180).mirrored().cuboid(-20.9688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 246).cuboid(15.2188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
        .uv(280, 246).mirrored().cuboid(-21.7188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-21.0F, 1.0313F, 2.5F, -0.3927F, 0.0F, 0.0F));

    ModelPartData whi3_r1 = whi3.addChild("whi3_r1", ModelPartBuilder.create().uv(247, 162).mirrored().cuboid(-20.4688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 162).cuboid(14.9688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 6.2698F, 19.2857F, -1.5708F, 0.0F, 0.0F));

    ModelPartData whi3_r2 = whi3.addChild("whi3_r2", ModelPartBuilder.create().uv(0, 281).mirrored().cuboid(-21.2188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 281).cuboid(14.7188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.7006F, 27.1098F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi3_r3 = whi3.addChild("whi3_r3", ModelPartBuilder.create().uv(16, 281).mirrored().cuboid(-21.2188F, 18.8241F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(16, 281).cuboid(14.7188F, 18.8241F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.153F, 23.2562F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi3_r4 = whi3.addChild("whi3_r4", ModelPartBuilder.create().uv(32, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(32, 281).cuboid(14.7188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -7.8956F, 22.7623F, 0.7854F, 0.0F, 0.0F));

    ModelPartData whi3_r5 = whi3.addChild("whi3_r5", ModelPartBuilder.create().uv(48, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(48, 281).cuboid(14.7188F, -14.1759F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.6279F, 17.4946F, 0.7854F, 0.0F, 0.0F));

    ModelPartData wheel3 = wheelssss.addChild("wheel3", ModelPartBuilder.create(), ModelTransform.pivot(21.0F, -5.3269F, -24.8032F));

    ModelPartData whi4 = wheel3.addChild("whi4", ModelPartBuilder.create().uv(184, 259).cuboid(14.2188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(184, 259).mirrored().cuboid(-21.7188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(37, 259).cuboid(14.2188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(37, 259).mirrored().cuboid(-21.7188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 254).cuboid(14.2188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 254).mirrored().cuboid(-21.7188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 250).cuboid(14.2188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 250).mirrored().cuboid(-21.7188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 180).cuboid(14.4688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F))
        .uv(247, 180).mirrored().cuboid(-20.9688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 246).cuboid(15.2188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
        .uv(280, 246).mirrored().cuboid(-21.7188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-21.0F, 1.0313F, 2.5F, -0.3927F, 0.0F, 0.0F));

    ModelPartData whi4_r1 = whi4.addChild("whi4_r1", ModelPartBuilder.create().uv(247, 162).mirrored().cuboid(-20.4688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 162).cuboid(14.9688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 6.2698F, 19.2857F, -1.5708F, 0.0F, 0.0F));

    ModelPartData whi4_r2 = whi4.addChild("whi4_r2", ModelPartBuilder.create().uv(0, 281).mirrored().cuboid(-21.2188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 281).cuboid(14.7188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.7006F, 27.1098F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi4_r3 = whi4.addChild("whi4_r3", ModelPartBuilder.create().uv(16, 281).mirrored().cuboid(-21.2188F, 18.8241F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(16, 281).cuboid(14.7188F, 18.8241F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.153F, 23.2562F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi4_r4 = whi4.addChild("whi4_r4", ModelPartBuilder.create().uv(32, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(32, 281).cuboid(14.7188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -7.8956F, 22.7623F, 0.7854F, 0.0F, 0.0F));

    ModelPartData whi4_r5 = whi4.addChild("whi4_r5", ModelPartBuilder.create().uv(48, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(48, 281).cuboid(14.7188F, -14.1759F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.6279F, 17.4946F, 0.7854F, 0.0F, 0.0F));

    ModelPartData wheel4 = wheelssss.addChild("wheel4", ModelPartBuilder.create(), ModelTransform.pivot(21.0F, -5.3269F, -34.8032F));

    ModelPartData whi5 = wheel4.addChild("whi5", ModelPartBuilder.create().uv(184, 259).cuboid(14.2188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(184, 259).mirrored().cuboid(-21.7188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(37, 259).cuboid(14.2188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(37, 259).mirrored().cuboid(-21.7188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 254).cuboid(14.2188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 254).mirrored().cuboid(-21.7188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 250).cuboid(14.2188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 250).mirrored().cuboid(-21.7188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 180).cuboid(14.4688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F))
        .uv(247, 180).mirrored().cuboid(-20.9688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 246).cuboid(15.2188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
        .uv(280, 246).mirrored().cuboid(-21.7188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-21.0F, 1.0313F, 2.5F, -0.3927F, 0.0F, 0.0F));

    ModelPartData whi5_r1 = whi5.addChild("whi5_r1", ModelPartBuilder.create().uv(247, 162).mirrored().cuboid(-20.4688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 162).cuboid(14.9688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 6.2698F, 19.2857F, -1.5708F, 0.0F, 0.0F));

    ModelPartData whi5_r2 = whi5.addChild("whi5_r2", ModelPartBuilder.create().uv(0, 281).mirrored().cuboid(-21.2188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 281).cuboid(14.7188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.7006F, 27.1098F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi5_r3 = whi5.addChild("whi5_r3", ModelPartBuilder.create().uv(16, 281).mirrored().cuboid(-21.2188F, 18.8241F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(16, 281).cuboid(14.7188F, 18.8241F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.153F, 23.2562F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi5_r4 = whi5.addChild("whi5_r4", ModelPartBuilder.create().uv(32, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(32, 281).cuboid(14.7188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -7.8956F, 22.7623F, 0.7854F, 0.0F, 0.0F));

    ModelPartData whi5_r5 = whi5.addChild("whi5_r5", ModelPartBuilder.create().uv(48, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(48, 281).cuboid(14.7188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.6279F, 17.4946F, 0.7854F, 0.0F, 0.0F));

    ModelPartData wheel5 = wheelssss.addChild("wheel5", ModelPartBuilder.create(), ModelTransform.pivot(21.0F, -5.3269F, -44.8032F));

    ModelPartData whi6 = wheel5.addChild("whi6", ModelPartBuilder.create().uv(184, 259).cuboid(14.2188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(184, 259).mirrored().cuboid(-21.7188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(37, 259).cuboid(14.2188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(37, 259).mirrored().cuboid(-21.7188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 254).cuboid(14.2188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 254).mirrored().cuboid(-21.7188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 250).cuboid(14.2188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 250).mirrored().cuboid(-21.7188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 180).cuboid(14.4688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F))
        .uv(247, 180).mirrored().cuboid(-20.9688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 246).cuboid(15.2188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
        .uv(280, 246).mirrored().cuboid(-21.7188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-21.0F, 1.0313F, 2.5F, -0.3927F, 0.0F, 0.0F));

    ModelPartData whi6_r1 = whi6.addChild("whi6_r1", ModelPartBuilder.create().uv(247, 162).mirrored().cuboid(-20.4688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 162).cuboid(14.9688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 6.2698F, 19.2857F, -1.5708F, 0.0F, 0.0F));

    ModelPartData whi6_r2 = whi6.addChild("whi6_r2", ModelPartBuilder.create().uv(0, 281).mirrored().cuboid(-21.2188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 281).cuboid(14.7188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.7006F, 27.1098F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi6_r3 = whi6.addChild("whi6_r3", ModelPartBuilder.create().uv(16, 281).mirrored().cuboid(-21.2188F, 18.8241F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(16, 281).cuboid(14.7188F, 18.8241F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.153F, 23.2562F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi6_r4 = whi6.addChild("whi6_r4", ModelPartBuilder.create().uv(32, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(32, 281).cuboid(14.7188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -7.8956F, 22.7623F, 0.7854F, 0.0F, 0.0F));

    ModelPartData whi6_r5 = whi6.addChild("whi6_r5", ModelPartBuilder.create().uv(48, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(48, 281).cuboid(14.7188F, -14.1759F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.6279F, 17.4946F, 0.7854F, 0.0F, 0.0F));

    ModelPartData wheel6 = wheelssss.addChild("wheel6", ModelPartBuilder.create(), ModelTransform.pivot(21.0F, -5.3269F, -54.8032F));

    ModelPartData whi7 = wheel6.addChild("whi7", ModelPartBuilder.create().uv(184, 259).cuboid(14.2188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(184, 259).mirrored().cuboid(-21.7188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(37, 259).cuboid(14.2188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(37, 259).mirrored().cuboid(-21.7188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 254).cuboid(14.2188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 254).mirrored().cuboid(-21.7188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 250).cuboid(14.2188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 250).mirrored().cuboid(-21.7188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 180).cuboid(14.4688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F))
        .uv(247, 180).mirrored().cuboid(-20.9688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 246).cuboid(15.2188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
        .uv(280, 246).mirrored().cuboid(-21.7188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-21.0F, 1.0313F, 2.5F, -0.3927F, 0.0F, 0.0F));

    ModelPartData whi7_r1 = whi7.addChild("whi7_r1", ModelPartBuilder.create().uv(247, 162).mirrored().cuboid(-20.4688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 162).cuboid(14.9688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 6.2698F, 19.2857F, -1.5708F, 0.0F, 0.0F));

    ModelPartData whi7_r2 = whi7.addChild("whi7_r2", ModelPartBuilder.create().uv(0, 281).mirrored().cuboid(-21.2188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 281).cuboid(14.7188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.7006F, 27.1098F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi7_r3 = whi7.addChild("whi7_r3", ModelPartBuilder.create().uv(16, 281).mirrored().cuboid(-21.2188F, 18.8241F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(16, 281).cuboid(14.7188F, 18.8241F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.153F, 23.2562F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi7_r4 = whi7.addChild("whi7_r4", ModelPartBuilder.create().uv(32, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(32, 281).cuboid(14.7188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -7.8956F, 22.7623F, 0.7854F, 0.0F, 0.0F));

    ModelPartData whi7_r5 = whi7.addChild("whi7_r5", ModelPartBuilder.create().uv(48, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(48, 281).cuboid(14.7188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.6279F, 17.4946F, 0.7854F, 0.0F, 0.0F));

    ModelPartData wheel7 = wheelssss.addChild("wheel7", ModelPartBuilder.create(), ModelTransform.pivot(21.0F, -5.3269F, -64.8032F));

    ModelPartData whi8 = wheel7.addChild("whi8", ModelPartBuilder.create().uv(184, 259).cuboid(14.2188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(184, 259).mirrored().cuboid(-21.7188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(37, 259).cuboid(14.2188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(37, 259).mirrored().cuboid(-21.7188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 254).cuboid(14.2188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 254).mirrored().cuboid(-21.7188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 250).cuboid(14.2188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 250).mirrored().cuboid(-21.7188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 180).cuboid(14.4688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F))
        .uv(247, 180).mirrored().cuboid(-20.9688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 246).cuboid(15.2188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
        .uv(280, 246).mirrored().cuboid(-21.7188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-21.0F, 1.0313F, 2.5F, -0.3927F, 0.0F, 0.0F));

    ModelPartData whi8_r1 = whi8.addChild("whi8_r1", ModelPartBuilder.create().uv(247, 162).mirrored().cuboid(-20.4688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 162).cuboid(14.9688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 6.2698F, 19.2857F, -1.5708F, 0.0F, 0.0F));

    ModelPartData whi8_r2 = whi8.addChild("whi8_r2", ModelPartBuilder.create().uv(0, 281).mirrored().cuboid(-21.2188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 281).cuboid(14.7188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.7006F, 27.1098F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi8_r3 = whi8.addChild("whi8_r3", ModelPartBuilder.create().uv(16, 281).mirrored().cuboid(-21.2188F, 18.8241F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(16, 281).cuboid(14.7188F, 18.8241F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.153F, 23.2562F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi8_r4 = whi8.addChild("whi8_r4", ModelPartBuilder.create().uv(32, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(32, 281).cuboid(14.7188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -7.8956F, 22.7623F, 0.7854F, 0.0F, 0.0F));

    ModelPartData whi8_r5 = whi8.addChild("whi8_r5", ModelPartBuilder.create().uv(48, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(48, 281).cuboid(14.7188F, -14.1759F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.6279F, 17.4946F, 0.7854F, 0.0F, 0.0F));

    ModelPartData wheel8 = wheelssss.addChild("wheel8", ModelPartBuilder.create(), ModelTransform.pivot(21.0F, -10.3269F, -88.8032F));

    ModelPartData whi9 = wheel8.addChild("whi9", ModelPartBuilder.create().uv(184, 259).cuboid(14.2188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(184, 259).mirrored().cuboid(-21.7188F, -4.2345F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(37, 259).cuboid(14.2188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(37, 259).mirrored().cuboid(-21.7188F, 3.2153F, -4.4466F, 7.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 254).cuboid(14.2188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 254).mirrored().cuboid(-21.7188F, -1.7596F, -6.9214F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 250).cuboid(14.2188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(280, 250).mirrored().cuboid(-21.7188F, -1.7596F, 0.5283F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 180).cuboid(14.4688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F))
        .uv(247, 180).mirrored().cuboid(-20.9688F, -3.406F, -4.6929F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(280, 246).cuboid(15.2188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
        .uv(280, 246).mirrored().cuboid(-21.7188F, -0.8846F, -3.7027F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-21.0F, 1.0313F, 2.5F, -0.3927F, 0.0F, 0.0F));

    ModelPartData whi9_r1 = whi9.addChild("whi9_r1", ModelPartBuilder.create().uv(247, 162).mirrored().cuboid(-20.4688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(247, 162).cuboid(14.9688F, 18.6366F, -8.1348F, 6.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 6.2698F, 19.2857F, -1.5708F, 0.0F, 0.0F));

    ModelPartData whi9_r2 = whi9.addChild("whi9_r2", ModelPartBuilder.create().uv(0, 281).mirrored().cuboid(-21.2188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 281).cuboid(14.7188F, 18.8241F, -18.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.7006F, 27.1098F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi9_r3 = whi9.addChild("whi9_r3", ModelPartBuilder.create().uv(16, 281).mirrored().cuboid(-21.2188F, 18.8241F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(16, 281).cuboid(14.7188F, 18.8241F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.153F, 23.2562F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi9_r4 = whi9.addChild("whi9_r4", ModelPartBuilder.create().uv(32, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(32, 281).cuboid(14.7188F, -14.1759F, -20.3535F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -7.8956F, 22.7623F, 0.7854F, 0.0F, 0.0F));

    ModelPartData whi9_r5 = whi9.addChild("whi9_r5", ModelPartBuilder.create().uv(48, 281).mirrored().cuboid(-21.2188F, -14.1759F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(48, 281).cuboid(14.7188F, -14.1759F, -20.3536F, 7.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.3926F, 17.6093F, 0.7854F, 0.0F, 0.0F));

    ModelPartData chainrailright = chainright.addChild("chainrailright", ModelPartBuilder.create(), ModelTransform.pivot(18.0F, -15.437F, -38.3816F));

    ModelPartData chainblock1 = chainrailright.addChild("chainblock1", ModelPartBuilder.create(), ModelTransform.of(26.0F, 0.0313F, 0.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock1_r1 = chainblock1.addChild("chainblock1_r1", ModelPartBuilder.create().uv(393, 23).cuboid(22.0F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 12.3316F, 39.745F, 0.0873F, 0.0F, 0.0F));

    ModelPartData chainblock59 = chainrailright.addChild("chainblock59", ModelPartBuilder.create(), ModelTransform.of(26.0F, 0.0313F, -3.9688F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock59_r1 = chainblock59.addChild("chainblock59_r1", ModelPartBuilder.create().uv(393, 23).cuboid(21.875F, -16.0F, -31.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 39.244F, -5.2941F, -1.309F, 0.0F, 0.0F));

    ModelPartData chainblock59_r2 = chainblock59.addChild("chainblock59_r2", ModelPartBuilder.create().uv(393, 23).cuboid(21.8125F, -16.0F, -35.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 30.3447F, -24.1691F, -1.9199F, 0.0F, 0.0F));

    ModelPartData chainblock59_r3 = chainblock59.addChild("chainblock59_r3", ModelPartBuilder.create().uv(393, 23).cuboid(21.9375F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 19.6687F, -32.2416F, -2.2689F, 0.0F, 0.0F));

    ModelPartData chainblock2 = chainrailright.addChild("chainblock2", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.5658F, -0.014F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 3.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock3 = chainrailright.addChild("chainblock3", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.6182F, -0.0135F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 6.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock4 = chainrailright.addChild("chainblock4", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.6705F, -0.013F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 9.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock5 = chainrailright.addChild("chainblock5", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.7229F, -0.0126F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 12.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock6 = chainrailright.addChild("chainblock6", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.7753F, -0.0121F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 15.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock7 = chainrailright.addChild("chainblock7", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.8276F, -0.0117F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 18.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock8 = chainrailright.addChild("chainblock8", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.88F, -0.0112F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 21.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock9 = chainrailright.addChild("chainblock9", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.9323F, -0.0108F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 24.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock10 = chainrailright.addChild("chainblock10", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -0.9847F, -0.0103F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 27.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock11 = chainrailright.addChild("chainblock11", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.0371F, -0.0099F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 30.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock12 = chainrailright.addChild("chainblock12", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.0894F, -0.0094F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 33.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock13 = chainrailright.addChild("chainblock13", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.1418F, -0.0089F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 36.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock14 = chainrailright.addChild("chainblock14", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.1941F, -0.0085F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 39.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock15 = chainrailright.addChild("chainblock15", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.2465F, -0.008F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 42.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock16 = chainrailright.addChild("chainblock16", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.2988F, -0.0076F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 45.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock17 = chainrailright.addChild("chainblock17", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.3512F, -0.0071F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 48.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock18 = chainrailright.addChild("chainblock18", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.4035F, -0.0066F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 51.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock19 = chainrailright.addChild("chainblock19", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.4559F, -0.0062F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 54.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock20 = chainrailright.addChild("chainblock20", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.5083F, -0.0057F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 57.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock21 = chainrailright.addChild("chainblock21", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.5606F, -0.0053F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 60.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock22 = chainrailright.addChild("chainblock22", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.613F, -0.0048F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 63.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock23 = chainrailright.addChild("chainblock23", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.6653F, -0.0044F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 66.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock24 = chainrailright.addChild("chainblock24", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.7177F, -0.0039F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 69.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock25 = chainrailright.addChild("chainblock25", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.77F, -0.0035F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 72.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock26 = chainrailright.addChild("chainblock26", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.8224F, -0.003F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 75.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock27 = chainrailright.addChild("chainblock27", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.8748F, -0.0025F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 78.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock28 = chainrailright.addChild("chainblock28", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.9271F, -0.0021F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 81.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock29 = chainrailright.addChild("chainblock29", ModelPartBuilder.create().uv(393, 23).cuboid(-4.0F, -1.9491F, -0.3453F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.0F, 0.0313F, 84.0313F, -0.1571F, 0.0F, 0.0F));

    ModelPartData chainblock60 = chainrailright.addChild("chainblock60", ModelPartBuilder.create(), ModelTransform.of(26.0F, 0.0313F, 89.0313F, -1.2043F, 0.0F, 0.0F));

    ModelPartData chainblock60_r1 = chainblock60.addChild("chainblock60_r1", ModelPartBuilder.create().uv(393, 23).cuboid(22.0313F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 3.2616F, 39.498F, 0.3491F, 0.0F, 0.0F));

    ModelPartData chainblock61 = chainrailright.addChild("chainblock61", ModelPartBuilder.create(), ModelTransform.of(26.0F, 3.0313F, 89.0313F, -1.8151F, 0.0F, 0.0F));

    ModelPartData chainblock61_r1 = chainblock61.addChild("chainblock61_r1", ModelPartBuilder.create().uv(393, 23).cuboid(22.0938F, -15.5819F, -34.5219F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 20.9589F, 31.9571F, -0.1745F, 0.0F, 0.0F));

    ModelPartData chainblock61_r2 = chainblock61.addChild("chainblock61_r2", ModelPartBuilder.create().uv(393, 23).cuboid(22.0625F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0F, 2.5124F, 39.4969F, 0.3491F, 0.0F, 0.0F));

    ModelPartData wheel9 = chainright.addChild("wheel9", ModelPartBuilder.create(), ModelTransform.pivot(48.375F, -12.4688F, 45.6875F));

    ModelPartData whi10 = wheel9.addChild("whi10", ModelPartBuilder.create().uv(75, 180).cuboid(13.0F, -4.3524F, -1.7447F, 8.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(75, 180).mirrored().cuboid(-24.25F, -4.3524F, -1.7447F, 8.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(177, 101).cuboid(13.0F, 3.0973F, -1.7447F, 8.0F, 1.0F, 3.5F, new Dilation(0.0F))
        .uv(177, 101).mirrored().cuboid(-24.25F, 3.0973F, -1.7447F, 8.0F, 1.0F, 3.5F, new Dilation(0.0F)).mirrored(false)
        .uv(259, 192).cuboid(13.0F, -1.8775F, -4.2196F, 8.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(259, 192).mirrored().cuboid(-24.25F, -1.8775F, -4.2196F, 8.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(183, 65).cuboid(13.0F, -1.8775F, 3.2301F, 8.0F, 3.5F, 1.0F, new Dilation(0.0F))
        .uv(183, 65).mirrored().cuboid(-24.25F, -1.8775F, 3.2301F, 8.0F, 3.5F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(173, 164).cuboid(14.0F, -3.524F, -1.9911F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F))
        .uv(173, 164).mirrored().cuboid(-21.25F, -3.524F, -1.9911F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(279, 118).cuboid(13.0F, -1.0025F, -1.0009F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
        .uv(279, 118).mirrored().cuboid(-22.25F, -1.0025F, -1.0009F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-21.0F, 0.0313F, 0.0F, -0.3927F, 0.0F, 0.0F));

    ModelPartData whi10_r1 = whi10.addChild("whi10_r1", ModelPartBuilder.create().uv(149, 115).mirrored().cuboid(-18.0F, 18.6366F, -8.1348F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
        .uv(149, 115).cuboid(17.25F, 18.6366F, -8.1348F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-3.25F, 6.1519F, 21.9875F, -1.5708F, 0.0F, 0.0F));

    ModelPartData whi10_r2 = whi10.addChild("whi10_r2", ModelPartBuilder.create().uv(91, 43).mirrored().cuboid(-21.0F, 18.8241F, -18.3536F, 1.0F, 3.5F, 2.0F, new Dilation(0.0F)).mirrored(false)
        .uv(91, 43).cuboid(23.25F, 18.8241F, -18.3536F, 1.0F, 3.5F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.25F, 0.5826F, 29.8116F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi10_r3 = whi10.addChild("whi10_r3", ModelPartBuilder.create().uv(188, 192).mirrored().cuboid(-21.0F, 18.8241F, -21.3536F, 8.0F, 3.5F, 2.0F, new Dilation(0.0F)).mirrored(false)
        .uv(188, 192).cuboid(16.25F, 18.8241F, -21.3536F, 8.0F, 3.5F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.25F, -3.2709F, 25.9581F, -0.7854F, 0.0F, 0.0F));

    ModelPartData whi10_r4 = whi10.addChild("whi10_r4", ModelPartBuilder.create().uv(91, 64).mirrored().cuboid(-21.0F, -14.1759F, -20.3535F, 1.0F, 3.5F, 2.0F, new Dilation(0.0F)).mirrored(false)
        .uv(91, 64).cuboid(23.25F, -14.1759F, -20.3535F, 1.0F, 3.5F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.25F, -8.0136F, 25.4642F, 0.7854F, 0.0F, 0.0F));

    ModelPartData whi10_r5 = whi10.addChild("whi10_r5", ModelPartBuilder.create().uv(4, 101).mirrored().cuboid(-21.0F, -14.1759F, -21.3535F, 1.0F, 3.5F, 2.0F, new Dilation(0.0F)).mirrored(false)
        .uv(4, 101).cuboid(23.25F, -14.1759F, -21.3535F, 1.0F, 3.5F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.25F, -2.7458F, 20.1964F, 0.7854F, 0.0F, 0.0F));

    ModelPartData chainleft = chainright.addChild("chainleft", ModelPartBuilder.create(), ModelTransform.pivot(51.5F, 0.0F, 0.0F));

    ModelPartData chainrailleft4 = chainleft.addChild("chainrailleft4", ModelPartBuilder.create(), ModelTransform.pivot(-18.0F, -15.437F, -38.3816F));

    ModelPartData chainblock91 = chainrailleft4.addChild("chainblock91", ModelPartBuilder.create(), ModelTransform.of(-26.0F, 0.0313F, 0.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock91_r1 = chainblock91.addChild("chainblock91_r1", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-30.0F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, 12.3316F, 39.745F, 0.0873F, 0.0F, 0.0F));

    ModelPartData chainblock92 = chainrailleft4.addChild("chainblock92", ModelPartBuilder.create(), ModelTransform.of(-26.0F, 0.0313F, -3.9688F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock92_r1 = chainblock92.addChild("chainblock92_r1", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-29.875F, -16.0F, -31.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, 39.244F, -5.2941F, -1.309F, 0.0F, 0.0F));

    ModelPartData chainblock92_r2 = chainblock92.addChild("chainblock92_r2", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-29.8125F, -16.0F, -35.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, 30.3447F, -24.1691F, -1.9199F, 0.0F, 0.0F));

    ModelPartData chainblock92_r3 = chainblock92.addChild("chainblock92_r3", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-29.9375F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, 19.6687F, -32.2416F, -2.2689F, 0.0F, 0.0F));

    ModelPartData chainblock93 = chainrailleft4.addChild("chainblock93", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.5658F, -0.014F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 3.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock94 = chainrailleft4.addChild("chainblock94", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.6182F, -0.0135F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 6.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock95 = chainrailleft4.addChild("chainblock95", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.6705F, -0.013F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 9.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock96 = chainrailleft4.addChild("chainblock96", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.7229F, -0.0126F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 12.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock97 = chainrailleft4.addChild("chainblock97", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.7753F, -0.0121F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 15.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock98 = chainrailleft4.addChild("chainblock98", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.8276F, -0.0117F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 18.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock99 = chainrailleft4.addChild("chainblock99", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.88F, -0.0112F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 21.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock100 = chainrailleft4.addChild("chainblock100", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.9323F, -0.0108F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 24.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock101 = chainrailleft4.addChild("chainblock101", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -0.9847F, -0.0103F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 27.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock102 = chainrailleft4.addChild("chainblock102", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.0371F, -0.0099F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 30.0312F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock103 = chainrailleft4.addChild("chainblock103", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.0894F, -0.0094F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 33.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock104 = chainrailleft4.addChild("chainblock104", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.1418F, -0.0089F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 36.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock105 = chainrailleft4.addChild("chainblock105", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.1941F, -0.0085F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 39.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock106 = chainrailleft4.addChild("chainblock106", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.2465F, -0.008F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 42.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock107 = chainrailleft4.addChild("chainblock107", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.2988F, -0.0076F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 45.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock108 = chainrailleft4.addChild("chainblock108", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.3512F, -0.0071F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 48.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock109 = chainrailleft4.addChild("chainblock109", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.4035F, -0.0066F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 51.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock110 = chainrailleft4.addChild("chainblock110", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.4559F, -0.0062F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 54.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock111 = chainrailleft4.addChild("chainblock111", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.5083F, -0.0057F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 57.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock112 = chainrailleft4.addChild("chainblock112", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.5606F, -0.0053F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 60.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock113 = chainrailleft4.addChild("chainblock113", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.613F, -0.0048F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 63.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock114 = chainrailleft4.addChild("chainblock114", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.6653F, -0.0044F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 66.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock115 = chainrailleft4.addChild("chainblock115", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.7177F, -0.0039F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 69.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock116 = chainrailleft4.addChild("chainblock116", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.77F, -0.0035F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 72.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock117 = chainrailleft4.addChild("chainblock117", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.8224F, -0.003F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 75.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock118 = chainrailleft4.addChild("chainblock118", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.8748F, -0.0025F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 78.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock119 = chainrailleft4.addChild("chainblock119", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.9271F, -0.0021F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 81.0313F, 0.0175F, 0.0F, 0.0F));

    ModelPartData chainblock120 = chainrailleft4.addChild("chainblock120", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-4.0F, -1.9491F, -0.3453F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-26.0F, 0.0313F, 84.0313F, -0.1571F, 0.0F, 0.0F));

    ModelPartData chainblock121 = chainrailleft4.addChild("chainblock121", ModelPartBuilder.create(), ModelTransform.of(-26.0F, 0.0313F, 89.0313F, -1.2043F, 0.0F, 0.0F));

    ModelPartData chainblock121_r1 = chainblock121.addChild("chainblock121_r1", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-30.0313F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, 3.2616F, 39.498F, 0.3491F, 0.0F, 0.0F));

    ModelPartData chainblock122 = chainrailleft4.addChild("chainblock122", ModelPartBuilder.create(), ModelTransform.of(-26.0F, 3.0313F, 89.0313F, -1.8151F, 0.0F, 0.0F));

    ModelPartData chainblock122_r1 = chainblock122.addChild("chainblock122_r1", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-30.0938F, -15.5819F, -34.5219F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, 20.9589F, 31.9571F, -0.1745F, 0.0F, 0.0F));

    ModelPartData chainblock122_r2 = chainblock122.addChild("chainblock122_r2", ModelPartBuilder.create().uv(393, 23).mirrored().cuboid(-30.0625F, -16.0F, -38.5F, 8.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(26.0F, 2.5124F, 39.4969F, 0.3491F, 0.0F, 0.0F));
    return TexturedModelData.of(modelData, 512, 512);
  }

  @Override
  public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    this.getPart().traverse().forEach(ModelPart::resetTransform);



    this.turret.yaw = netHeadYaw * 0.017453292F; // 0.017453292F = 1 degree

    this.barrel.pitch = headPitch * 0.017453292F; // 0.017453292F = 1 degree

  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
    tank.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }

  @Override
  public ModelPart getPart() {
    return tank;
  }

}