package mod.coder2195.america.entity.client;

import mod.coder2195.america.entity.custom.M1A2Entity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class M1A2Renderer extends MobEntityRenderer<M1A2Entity, M1A2Model<M1A2Entity>> {
  private static final Identifier TEXTURE = new Identifier("america", "textures/entity/m1a2.png");

  public M1A2Renderer(EntityRendererFactory.Context context) {
    super(context, new M1A2Model(context.getPart(ModModelLayers.M1A2)), 1f);
  }

                      @Override
  public Identifier getTexture(M1A2Entity entity) {
    return TEXTURE;
  }

  @Override
  public void render(M1A2Entity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
    matrixStack.scale(1.0F, 1.0F, 1.0F);

    super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
  }
}
